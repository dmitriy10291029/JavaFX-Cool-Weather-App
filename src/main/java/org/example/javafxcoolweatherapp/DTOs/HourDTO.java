package org.example.javafxcoolweatherapp.DTOs;

public class HourDTO {
    private final int hour;
    private final int temp;
    private final String description;

    public HourDTO(int hour, int temp, String description) {
        this.hour = hour;
        this.temp = temp;
        this.description = description;
    }

    public int getHour() {
        return hour;
    }

    public int getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }
}
