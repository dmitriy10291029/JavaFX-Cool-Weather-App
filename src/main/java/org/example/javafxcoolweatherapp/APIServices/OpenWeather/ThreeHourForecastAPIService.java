package org.example.javafxcoolweatherapp.APIServices.OpenWeather;

import org.example.javafxcoolweatherapp.APIServices.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.DataObjects.GeoData;
import org.example.javafxcoolweatherapp.DataObjects.ThreeHourForecast;

import java.io.IOException;

public class ThreeHourForecastAPIService
        extends AbstractCacheableSimpleAPIService< ThreeHourForecast > {

    private final GeoAPIService geoAPIService;

    public ThreeHourForecastAPIService(String APIKey, GeoAPIService geoAPIService) {
        super(APIKey, "open-weather-three-hour-cache");
        this.geoAPIService = geoAPIService;
    }

    @Override
    protected String getResponseByURL(String parameter) throws IOException {
        GeoData geoData = geoAPIService.getData(parameter);
        return urlManager.getData(String.format(
                "https://api.openweathermap.org/data/2.5/forecast?lat=%f&lon=%f&units=metric&appid=%s",
                geoData.getLat(), geoData.getLon(), APIKey
        ));
    }

    @Override
    protected ThreeHourForecast parseJSONResponseImpl(String data) throws IOException {
        return new ThreeHourForecast(DataObjectsJSONParser.parseTimeStampsList(data));
    }
}
