package org.example.javafxcoolweatherapp.Sources;

import org.example.javafxcoolweatherapp.DataObjects.DayDataObject;

import java.util.List;

public interface DaySource {
    List<DayDataObject> getDayList(final String city);
}
