package org.example.javafxcoolweatherapp.APIServices;

import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;
import org.example.javafxcoolweatherapp.URL.SimpleURLManager;
import org.example.javafxcoolweatherapp.URL.URLManager;

public class OpenWeatherAPICallBuilder implements WeatherAPICallBuilder {
    private final String APIKey;
    private final URLManager urlManager;

    public OpenWeatherAPICallBuilder(String APIKey) {
        this.APIKey = APIKey;
        urlManager = new SimpleURLManager();
    }

    @Override
    public String getAPICall(String city) {

        return null;
    }

    private GeoDataObject getGeoData(String city) {
        // json
        return null;
    }

    private String getResponseByGeocoding(String city) {
        return urlManager.getData(String.format(
                "http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", city, APIKey
        ));
    }
}
