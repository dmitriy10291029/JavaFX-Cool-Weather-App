package org.example.javafxcoolweatherapp.DTOs;

public class DayDTO {
    private final String dayOfWeek;
    private final int temp;
    private final String description;

    public DayDTO(String dayOfWeek, int temp, String description) {
        this.dayOfWeek = dayOfWeek;
        this.temp = temp;
        this.description = description;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }
}
