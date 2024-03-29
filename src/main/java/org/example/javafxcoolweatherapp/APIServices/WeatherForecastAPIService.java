package org.example.javafxcoolweatherapp.APIServices;

import org.example.javafxcoolweatherapp.DataObjects.HourlyForecastDataObject;

public interface WeatherForecastAPIService {
    HourlyForecastDataObject getActualHourlyForecast();
}
