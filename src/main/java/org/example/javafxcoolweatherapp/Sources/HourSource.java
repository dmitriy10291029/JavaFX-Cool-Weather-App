package org.example.javafxcoolweatherapp.Sources;

import org.example.javafxcoolweatherapp.DataObjects.HourDataObject;

import java.util.List;

public interface HourSource {
    List<HourDataObject> getHourList(final String city);
}
