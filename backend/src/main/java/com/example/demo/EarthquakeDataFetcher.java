package com.example.demo;

import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.springframework.stereotype.Component;

@Component
public class EarthquakeDataFetcher implements SourceFunction<String> {

    @Override
    public void run(SourceContext<String> ctx) throws Exception {
        // Mocking data fetch, replace it with actual logic
        ctx.collect("{\"latitude\": 34.05, \"longitude\": -118.25, \"intensity\": 5.0}");
        ctx.collect("{\"latitude\": 61.18, \"longitude\": -149.9, \"intensity\": 3.5}");
    }

    @Override
    public void cancel() {
        // Cancel operation if necessary
    }
}