// EarthquakeController.java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/earthquake")
public class EarthquakeController {

    private final EarthquakeService earthquakeService;

    @Autowired
    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    @GetMapping("/generateRandomEarthquake")
    public EarthquakeData generateRandomEarthquake() {
        return EarthquakeService.generateRandomEarthquakeData();
    }

    @GetMapping("/extraordinary")
    public List<EarthquakeData> getExtraordinaryEarthquakes() throws Exception {
        return earthquakeService.startAndExecuteJob();
    }
}
