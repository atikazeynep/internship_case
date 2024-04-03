package com.example.demo.service;

import com.example.demo.model.Earthquake;
import org.springframework.stereotype.Service;

@Service
public class EarthquakeService {

    // You may inject repositories or other services as needed

    // Example method to process earthquake data
    public void processEarthquakeData(Earthquake earthquake) {
        System.out.println("Received earthquake data:");
        System.out.println("Latitude: " + earthquake.getLatitude());
        System.out.println("Longitude: " + earthquake.getLongitude());
        System.out.println("Intensity: " + earthquake.getIntensity());
        System.out.println("Timestamp: " + earthquake.getTimestamp());

        // Here you can perform any processing logic, such as saving to a database
        System.out.println("Received earthquake data: " + earthquake.toString());
        // Example: Save the earthquake data to a database
        // earthquakeRepository.save(earthquake);
    }
}
