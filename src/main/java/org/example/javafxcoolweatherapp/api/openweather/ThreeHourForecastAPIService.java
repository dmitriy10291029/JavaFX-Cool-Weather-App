package org.example.javafxcoolweatherapp.api.openweather;

import org.example.javafxcoolweatherapp.api.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.model.GeoData;
import org.example.javafxcoolweatherapp.model.ThreeHourForecast;
import org.example.javafxcoolweatherapp.data.DataObjectsJSONParser;

import java.io.IOException;

public class ThreeHourForecastAPIService
        extends AbstractCacheableSimpleAPIService< ThreeHourForecast > {

    private final GeoAPIService geoAPIService;

    public ThreeHourForecastAPIService(String APIKey, GeoAPIService geoAPIService) {
        super(APIKey, "open-weather-three-hour-cache");
        this.geoAPIService = geoAPIService;
    }

    @Override
    protected String getResponseByURLImpl(String parameter) throws IOException {
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
