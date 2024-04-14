import React, { useEffect, useState } from 'react';
import { MapContainer, TileLayer, CircleMarker, Popup } from 'react-leaflet';
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';

const MapComponent = () => {
  const [earthquakeData, setEarthquakeData] = useState([]);

  // Fetch earthquake data from backend and update every 5 seconds
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/earthquake/generateRandomEarthquake');
        if (!response.ok) {
          throw new Error('Failed to fetch earthquake data');
        }
        const data = await response.json();
        setEarthquakeData(prevData => [...prevData, data]); // Append new data to existing data
        setTimeout(() => {
          setEarthquakeData(prevData => prevData.slice(1)); // Remove oldest data after 20 seconds
        }, 20000);
      } catch (error) {
        console.error('Error fetching earthquake data:', error);
      }
    };

    const interval = setInterval(fetchData, 5000);

    return () => clearInterval(interval);
  }, []);

  // Function to group earthquakes within a 50km radius into the same region
  const groupEarthquakes = (data) => {
    const groupedData = [];
    
    // Check if data is an array
    if (Array.isArray(data)) {
      data.forEach((earthquake) => {
        const isAbnormal = earthquake.abnormal;
        const existingRegion = groupedData.find((group) =>
          L.latLng(earthquake.latitude, earthquake.longitude).distanceTo(
            L.latLng(group.latitude, group.longitude)
          ) <= 50000
        );
  
        if (existingRegion) {
          existingRegion.earthquakes.push({ ...earthquake, abnormal: isAbnormal });
        } else {
          groupedData.push({
            latitude: earthquake.latitude,
            longitude: earthquake.longitude,
            earthquakes: [{ ...earthquake, abnormal: isAbnormal }],
          });
        }
      });
    } else {
      console.error('Error: Data is not an array');
    }
  
    return groupedData;
  };

  return (
    <MapContainer center={[0, 0]} zoom={2} style={{ height: '100vh' }}>
      <TileLayer
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
      />
      {groupEarthquakes(earthquakeData).map((region, index) => (
        region.earthquakes.map((earthquake, idx) => (
          <CircleMarker
            key={`${index}-${idx}`}
            center={[region.latitude, region.longitude]}
            radius={10} // Adjust the radius as needed
            color={earthquake.abnormal ? 'red' : 'blue'}
          >
            <Popup>
              <div>
                <strong>Location:</strong> {earthquake.location}<br />
                <strong>Magnitude:</strong> {earthquake.magnitude}
              </div>
            </Popup>
          </CircleMarker>
        ))
      ))}
    </MapContainer>
  );
};

export default MapComponent;
