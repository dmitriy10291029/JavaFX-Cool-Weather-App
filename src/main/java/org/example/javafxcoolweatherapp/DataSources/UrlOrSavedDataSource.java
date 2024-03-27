package org.example.javafxcoolweatherapp.DataSources;

import org.example.javafxcoolweatherapp.DataObjects.DayDataObject;
import org.example.javafxcoolweatherapp.DataObjects.HourDataObject;

import java.util.List;

public class UrlOrSavedDataSource implements DataSource {
    @Override
    public List<DayDataObject> getDayList(String city) {
        return null;
    }

    @Override
    public List<HourDataObject> getHourList(String city) {
        return null;
    }

    @Override
    public List<String> getRecentCitiesList() {
        return null;
    }

    @Override
    public boolean deleteRecentCity(String city) {
        return false;
    }

    @Override
    public boolean addRecentCity(String city) {
        return false;
    }
}
