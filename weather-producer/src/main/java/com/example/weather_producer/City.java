package com.example.weather_producer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum City {
    MAGADAN("Magadan"),
    SAINT_PETERSBURG("Saint Petersburg"),
    CHUKOTKA("Chukotka"),
    TYUMEN("Tyumen");
    private String name;

    public static int getLength() {
        return values().length;
    }
}