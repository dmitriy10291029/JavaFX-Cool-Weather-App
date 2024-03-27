package org.example.javafxcoolweatherapp.APIServices;

import org.example.javafxcoolweatherapp.Sources.DaySource;
import org.example.javafxcoolweatherapp.Sources.HourSource;

public interface WeatherAPIService extends HourSource, DaySource, RecentCityCacheable {

}
