package org.example.javafxcoolweatherapp.DataObjects;

public class HourDataObject {
    private final int hour;
    private final int temp;
    private final String description;

    public HourDataObject(int hour, int temp, String description) {
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
