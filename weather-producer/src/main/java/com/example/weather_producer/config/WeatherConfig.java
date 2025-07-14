package com.example.weather_producer.config;

import com.example.weather_producer.City;
import com.example.weather_producer.Weather;
import com.example.weather_producer.WeatherCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Configuration
public class WeatherConfig {

    private final Random random = new Random();

    @Bean
    @Scope("prototype")
    public Weather randomWeather() {
        return Weather.builder()
                .id(UUID.randomUUID()
                        .toString())
                .city(City.values()[random.nextInt(City.getLength())])
                .temperature(random.nextInt(36) + random.nextDouble())
                .condition(WeatherCondition.values()[random.nextInt(WeatherCondition.getLength())])
                .date(LocalDate.now()
                        .plusDays(Weather.counter.getAndIncrement()))
                .timestamp(Instant.now())
                .build();
    }
}
