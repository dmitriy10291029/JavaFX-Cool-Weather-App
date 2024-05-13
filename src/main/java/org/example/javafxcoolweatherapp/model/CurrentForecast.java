package org.example.javafxcoolweatherapp.model;

import java.util.List;

public class CurrentForecast extends AbstractForecast {
    public CurrentForecast(List<TimeStamp> timeStamps) throws IllegalArgumentException {
        super(timeStamps, 1);
    }
}
