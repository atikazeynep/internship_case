package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class EarthquakeDataParser {

    public static EarthquakeData parseJson(String jsonString) {
        JSONObject json = new JSONObject(jsonString);
        JSONArray features = json.getJSONArray("features");
        // Extract earthquake data from JSON and create EarthquakeData object
        JSONObject properties = features.getJSONObject(0).getJSONObject("properties");
        double magnitude = properties.getDouble("mag");
        String place = properties.getString("place");
        return new EarthquakeData(magnitude, place);
    }
}

