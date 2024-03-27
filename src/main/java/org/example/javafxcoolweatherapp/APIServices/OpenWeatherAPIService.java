package org.example.javafxcoolweatherapp.APIServices;

import org.example.javafxcoolweatherapp.DataObjects.DayDataObject;
import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;
import org.example.javafxcoolweatherapp.DataObjects.HourDataObject;
import org.example.javafxcoolweatherapp.URL.SimpleURLManager;
import org.example.javafxcoolweatherapp.URL.URLManager;

import java.util.List;

public class OpenWeatherAPIService implements WeatherAPIService {
    private final String APIKey;
    private final URLManager urlManager;

    public OpenWeatherAPIService(String APIKey) {
        this.APIKey = APIKey;
        urlManager = new SimpleURLManager();
    }

    @Override
    public List<DayDataObject> getDayList(String city) {
        // check in savings
        // parse saved data or make response and parse it
        return null;
    }

    @Override
    public List<HourDataObject> getHourList(String city) {
        // check in savings
        // parse saved data or make response and parse it
        return null;
    }

    private String getResponseWithWeather(GeoDataObject geoData) {
        return urlManager.getData(String.format(
                "https://pro.openweathermap.org/data/2.5/forecast/hourly?lat=%f&lon=%f&appid=%s",
                geoData.getLat(), geoData.getLon(), APIKey
        ));
    }

    private GeoDataObject getGeoData(String city) {
        // check in savings
        // parse saved data or make response and parse it
        return null;
    }

    private String getResponseByGeocoding(String city) {
        return urlManager.getData(String.format(
                "http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", city, APIKey
        ));
    }

    @Override
    public List<String> getRecentCitiesList() {
        // check all files in savings
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
