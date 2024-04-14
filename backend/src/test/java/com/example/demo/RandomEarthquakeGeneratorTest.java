package com.example.demo;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class RandomEarthquakeGeneratorTest {

    @Test
    public void testGenerateRandomEarthquakeData() {
        int numberOfTests = 100; // Number of random earthquake data instances to generate

        for (int i = 0; i < numberOfTests; i++) {
            EarthquakeData earthquakeData = RandomEarthquakeGenerator.generateRandomEarthquakeData();

            // Verify latitude falls within the range -90 to 90
            assertTrue("Latitude should be between -90 and 90",
                    earthquakeData.getLatitude() >= -90.0 && earthquakeData.getLatitude() <= 90.0);

            // Verify longitude falls within the range -180 to 180
            assertTrue("Longitude should be between -180 and 180",
                    earthquakeData.getLongitude() >= -180.0 && earthquakeData.getLongitude() <= 180.0);

            // Verify intensity falls within the range 0 to 10
            assertTrue("Intensity should be between 0 and 10",
                    earthquakeData.getIntensity() >= 0.0 && earthquakeData.getIntensity() <= 10.0);

            // Log the generated earthquake data
            System.out.println("Generated Earthquake Data #" + (i + 1) + ":");
            System.out.println("Latitude: " + earthquakeData.getLatitude());
            System.out.println("Longitude: " + earthquakeData.getLongitude());
            System.out.println("Intensity: " + earthquakeData.getIntensity());
            System.out.println(); // Add a newline for readability
        }
    }
}
