package com.example.weather_consumer.service;

import com.example.weather_consumer.Weather;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WeatherConsumerService {

    @KafkaListener(topics = "weather-topic", groupId = "weather-group", containerFactory = "containerFactory")
    public void readWeatherReport(Weather weather) {
        System.out.println(weather.toString());
    }
}
