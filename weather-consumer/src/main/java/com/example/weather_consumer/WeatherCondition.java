package com.example.weather_consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WeatherCondition {
    SUNNY("Sunny"),
    PARTLY_CLOUDY("Partly cloudy"),
    CLOUDY("Cloudy"),
    RAIN("Rain"),
    SNOW("Snow"),
    FOG("Fog"),
    THUNDERSTORM("Thunderstorm");
    private String condition;

    public static int getLength() {
        return values().length;
    }
}
