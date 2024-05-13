package org.example.javafxcoolweatherapp.model;

import java.util.List;

public class ThreeHourForecast extends AbstractForecast {
    public ThreeHourForecast(List<TimeStamp> timeStamps) throws IllegalArgumentException {
        super(timeStamps, 24 / 3);
    }
}
