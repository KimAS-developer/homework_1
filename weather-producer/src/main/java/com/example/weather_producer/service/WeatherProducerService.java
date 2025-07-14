package com.example.weather_producer.service;

import com.example.weather_producer.Weather;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherProducerService {

    private final ApplicationContext context;

    private final KafkaTemplate<String, Weather> kafkaTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendWeatherReport() {
        kafkaTemplate.send("weather-topic", context.getBean(Weather.class));
    }
}
