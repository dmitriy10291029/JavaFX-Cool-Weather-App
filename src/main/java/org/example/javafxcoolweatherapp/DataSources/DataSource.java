package org.example.javafxcoolweatherapp.DataSources;

import org.example.javafxcoolweatherapp.DTOs.DayDTO;
import org.example.javafxcoolweatherapp.DTOs.HourDTO;

import java.util.List;

/**
 * Внешний интерфейс для взаимодействия с данными
 */
public interface DataSource {
    List<DayDTO> getDayList(final String city);
    List<HourDTO> getHourList(final String city);

    List<String> getRecentCitiesList();
    boolean deleteRecentCity(final String city);
    boolean addRecentCity(final String city);
}
