package com.example.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class EarthquakeDataParser {

    // Assuming that the timestamp is in milliseconds since epoch
    private static final long MILLISECONDS_IN_AN_HOUR = 3600000L;

    public static List<EarthquakeData> parseJson(String jsonString) throws JSONException {
        List<EarthquakeData> earthquakeDataList = new ArrayList<>();

        JSONObject json = new JSONObject(jsonString);
        JSONArray features = json.getJSONArray("features");

        Instant currentTime = Instant.now();

        for (int i = 0; i < features.length(); i++) {
            JSONObject feature = features.getJSONObject(i);
            JSONObject properties = feature.getJSONObject("properties");
            long timestamp = properties.getLong("time");
            Instant earthquakeTime = Instant.ofEpochMilli(timestamp);

            // Check if the earthquake occurred within the last hour
            if (earthquakeTime.isAfter(currentTime.minus(1, ChronoUnit.HOURS))) {
                JSONObject geometry = feature.getJSONObject("geometry");
                JSONArray coordinates = geometry.getJSONArray("coordinates");
                double longitude = coordinates.getDouble(0);
                double latitude = coordinates.getDouble(1);
                double intensity = properties.getDouble("mag");
                EarthquakeData earthquakeData = new EarthquakeData(latitude, longitude, intensity);
                earthquakeDataList.add(earthquakeData);
            }
        }

        return earthquakeDataList;
    }
}
