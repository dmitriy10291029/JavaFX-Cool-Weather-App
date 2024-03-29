package org.example.javafxcoolweatherapp.APIServices;

import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;

public interface GeocodingAPIService {
    GeoDataObject getGeoData(String city);
}
