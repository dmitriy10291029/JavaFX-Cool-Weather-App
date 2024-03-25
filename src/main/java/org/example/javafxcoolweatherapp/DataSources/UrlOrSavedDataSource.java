package org.example.javafxcoolweatherapp.DataSources;

import org.example.javafxcoolweatherapp.DTOs.DayDTO;
import org.example.javafxcoolweatherapp.DTOs.HourDTO;

import java.util.List;

public class UrlOrSavedDataSource implements DataSource {
    @Override
    public List<DayDTO> getDayList(String city) {
        return null;
    }

    @Override
    public List<HourDTO> getHourList(String city) {
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
