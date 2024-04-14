package com.example.demo;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.ArrayList;
import java.util.List;

public class TestSink<T> implements SinkFunction<T> {
    private final List<T> collectedResults = new ArrayList<>();

    @Override
    public synchronized void invoke(T value, Context context) throws Exception {
        collectedResults.add(value);
    }

    public List<T> getCollectedResults() {
        return collectedResults;
    }
}
