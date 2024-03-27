package org.example.javafxcoolweatherapp.DataObjects;

public class DayDataObject {
    private final String dayOfWeek;
    private final int temp;
    private final String description;

    public DayDataObject(String dayOfWeek, int temp, String description) {
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
