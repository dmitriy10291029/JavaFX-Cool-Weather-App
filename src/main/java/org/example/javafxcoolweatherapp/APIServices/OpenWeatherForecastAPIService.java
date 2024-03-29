package org.example.javafxcoolweatherapp.APIServices;

import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;
import org.example.javafxcoolweatherapp.DataObjects.HourlyForecastDataObject;
import org.example.javafxcoolweatherapp.Files.FileManager;
import org.example.javafxcoolweatherapp.Files.SimpleFileManager;
import org.example.javafxcoolweatherapp.URL.SimpleURLManager;
import org.example.javafxcoolweatherapp.URL.URLManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class OpenWeatherForecastAPIService implements WeatherForecastAPIService, RecentCityCacheable {
    private final String APIKey;
    private final URLManager urlManager;
    private FileManager geoFileManager;
    private FileManager weatherFileManager;
    private boolean cacheAccess;

    public OpenWeatherForecastAPIService(String APIKey) {
        this.APIKey = APIKey;
        urlManager = new SimpleURLManager();
        try {
            weatherFileManager = new SimpleFileManager("open-weather-cache-hourly");
            geoFileManager = new SimpleFileManager("open-weather-cache-geo");
            cacheAccess = true;
        } catch (IOException e) {
            weatherFileManager = null;
            geoFileManager = null;
            cacheAccess = false;
        }
    }

    @Override
    public HourlyForecastDataObject getActualHourlyForecast() {
        return null;
    }

    @Override
    public List<String> getRecentCitiesList() {
        return weatherFileManager.getFilesList();
    }

    @Override
    public boolean deleteRecentCity(String city) {
        return weatherFileManager.deleteFile(city);
    }

    private String getResponseWithWeather(GeoDataObject geoData) {
        return urlManager.getData(String.format(
                "https://pro.openweathermap.org/data/2.5/forecast/hourly?lat=%f&lon=%f&appid=%s",
                geoData.getLat(), geoData.getLon(), APIKey
        ));
    }

    public GeoDataObject getGeoData(String city) {
        GeoDataObject cachedGeoData = getCachedGeoData(city);
        if (cachedGeoData != null) {
            return cachedGeoData;
        } else {
            return getGeoDataByURL(city);

        }
    }

    private GeoDataObject getGeoDataByURL(String city) {
        String response = getResponseByGeocoding(city);
        GeoDataObject newGeoData = parseJSONResponse(response);
        if (newGeoData != null) {
            if (cacheAccess) {
                geoFileManager.saveDataToFile(city, response);
            }
            return newGeoData;
        }
        return null;
    }

    private GeoDataObject getCachedGeoData(String city) {
        if (cacheAccess && geoFileManager.getFilesList().contains(city)) {
            return parseJSONResponse(geoFileManager.readData(city));
        }
        return null;
    }

    private GeoDataObject parseJSONResponse(String data) {
        if (data == null) {
            return null;
        }
        try {
            JSONParser parser = new JSONParser();
            JSONArray citiesArray = (JSONArray) parser.parse(data);
            JSONObject firstCity = (JSONObject) citiesArray.get(0);
            return new GeoDataObject((double) firstCity.get("lat"), (double) firstCity.get("lon"));
        } catch (ParseException e) {
            return null;
        }
    }

    private String getResponseByGeocoding(String city) {
        return urlManager.getData(String.format(
                "http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", city, APIKey
        ));
    }
}
