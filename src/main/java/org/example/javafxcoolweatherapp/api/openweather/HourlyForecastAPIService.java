package org.example.javafxcoolweatherapp.api.openweather;

import org.example.javafxcoolweatherapp.api.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.model.GeoData;
import org.example.javafxcoolweatherapp.model.HourlyForecast;
import org.example.javafxcoolweatherapp.data.DataObjectsJSONParser;

import java.io.IOException;

public class HourlyForecastAPIService
        extends AbstractCacheableSimpleAPIService< HourlyForecast > {

    private final GeoAPIService geoAPIService;

    public HourlyForecastAPIService(String APIKey, GeoAPIService geoAPIService) {
        super(APIKey, "open-weather-hourly-cache");
        this.geoAPIService = geoAPIService;
    }

    @Override
    protected String getResponseByURLImpl(String parameter) throws IOException {
        GeoData geoData = geoAPIService.getData(parameter);
        return urlManager.getData(String.format(
                "https://pro.openweathermap.org/data/2.5/forecast/hourly?lat=%f&lon=%f&appid=%s",
                geoData.getLat(), geoData.getLon(), APIKey
        ));
    }

    @Override
    protected HourlyForecast parseJSONResponseImpl(String data) throws IOException {
        return new HourlyForecast(DataObjectsJSONParser.parseTimeStampsList(data));
    }
}
