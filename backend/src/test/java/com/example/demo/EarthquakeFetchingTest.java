package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EarthquakeFetchingTest {
    @Autowired
    private EarthquakeController earthquakeController;

    @Autowired
    private EarthquakeService earthquakeService;

    @Test
    void getExtraordinaryEarthquakes() {
        try {
            // Retrieve extraordinary earthquakes
            List<EarthquakeData> extraordinaryEarthquakes = earthquakeController.getExtraordinaryEarthquakes();
            assertNotNull(extraordinaryEarthquakes);
            assertTrue(extraordinaryEarthquakes.size() > 0);
            // Add more assertions as needed based on the expected data
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
