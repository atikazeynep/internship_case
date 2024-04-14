package com.example.demo;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class EarthquakeService {

    private final StreamExecutionEnvironment env;
    private final RestTemplate restTemplate;

    @Autowired
    public EarthquakeService(StreamExecutionEnvironment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
    }

    public List<EarthquakeData> startAndExecuteJob() {
        try {
            // Fetch earthquake data from the API
            String apiUrl = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";
            String earthquakeData = restTemplate.getForObject(apiUrl, String.class);

            // Parse JSON response to extract earthquake data list
            List<EarthquakeData> earthquakeDataList = EarthquakeDataParser.parseJson(earthquakeData);

            // Filter the earthquake data list to get extraordinary earthquakes
            List<EarthquakeData> extraordinaryEarthquakes = earthquakeDataList.stream()
                    .filter(earthquake -> earthquake.getIntensity() > 3.0)
                    .collect(Collectors.toList());

            // Print the extraordinary earthquakes
            extraordinaryEarthquakes.forEach(System.out::println);

            return extraordinaryEarthquakes;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // Method to generate random latitude (-90 to 90)
    private static double generateRandomLatitude() {
        Random rand = new Random();
        return -90.0 + (90.0 - (-90.0)) * rand.nextDouble();
    }

    // Method to generate random longitude (-180 to 180)
    private static double generateRandomLongitude() {
        Random rand = new Random();
        return -180.0 + (180.0 - (-180.0)) * rand.nextDouble();
    }

    // Method to generate random intensity (0 to 10)
    private static double generateRandomIntensity() {
        Random rand = new Random();
        return 10.0 * rand.nextDouble();
    }

    // Method to generate random earthquake data
    public static EarthquakeData generateRandomEarthquakeData() {
        double latitude = generateRandomLatitude();
        double longitude = generateRandomLongitude();
        double intensity = generateRandomIntensity();

        // You can add more attributes here if needed

        return new EarthquakeData(latitude, longitude, intensity);
    }

}
