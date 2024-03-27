package org.example.javafxcoolweatherapp.DataSources;

import org.example.javafxcoolweatherapp.DataObjects.DayDataObject;
import org.example.javafxcoolweatherapp.DataObjects.HourDataObject;

import java.util.List;

public interface DataSource {
    List<DayDataObject> getDayList(final String city);
    List<HourDataObject> getHourList(final String city);

    List<String> getRecentCitiesList();
    boolean deleteRecentCity(final String city);
    boolean addRecentCity(final String city);
}
