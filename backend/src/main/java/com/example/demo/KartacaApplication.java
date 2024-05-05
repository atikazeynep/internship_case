package com.example.demo;
//a small commentimsi
//a new one
//abartmak
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class KartacaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(KartacaApplication.class, args);

		EarthquakeService earthquakeService = context.getBean(EarthquakeService.class);
	}

	@Bean
	public StreamExecutionEnvironment flinkExecutionEnvironment() {
		return StreamExecutionEnvironment.getExecutionEnvironment();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public EarthquakeService earthquakeService(StreamExecutionEnvironment env, RestTemplate restTemplate) {
		return new EarthquakeService(env, restTemplate);
	}

}
