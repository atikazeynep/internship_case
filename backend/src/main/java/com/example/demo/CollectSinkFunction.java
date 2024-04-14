package com.example.demo;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction.Context;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.List;

public class CollectSinkFunction<T> implements SinkFunction<T> {
    private final List<T> collectedData = new ArrayList<>();

    @Override
    public void invoke(T value, Context context) throws Exception {
        collectedData.add(value);
    }

    public List<T> getCollectedData() {
        return collectedData;
    }
}

