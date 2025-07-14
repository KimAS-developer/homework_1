package com.example.weather_producer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
@Getter
@ToString
public class Weather {
    public static AtomicInteger counter = new AtomicInteger();
    private String id;
    private Instant timestamp;
    private double temperature;
    private WeatherCondition condition;
    private City city;
    private LocalDate date;
}
