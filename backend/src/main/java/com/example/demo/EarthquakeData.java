package com.example.demo;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

// Example of a class representing earthquake data
public class EarthquakeData {
    private double latitude;
    private double longitude;
    private double intensity;

    // Constructor
    public EarthquakeData(double latitude, double longitude, double intensity) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.intensity = intensity;
    }

    public EarthquakeData() {
    }

    // Getters and setters (if needed)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public String toJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Create a JSON string representation of the EarthquakeData object
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null; // Return null if an error occurs during JSON serialization
        }
    }

}
