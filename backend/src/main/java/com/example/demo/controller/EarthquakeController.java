package com.example.demo.controller;


import com.example.demo.model.Earthquake;
import com.example.demo.service.EarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/process-earthquakes")
public class EarthquakeController {

    @Autowired
    private final EarthquakeService earthquakeService;

    @Autowired
    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    @PostMapping
    public String processEarthquakeData(@RequestBody Earthquake earthquake) {
        // Process the received earthquake data (e.g., save to database)
        earthquakeService.processEarthquakeData(earthquake);
        return "Earthquake data processed successfully";
    }
}
