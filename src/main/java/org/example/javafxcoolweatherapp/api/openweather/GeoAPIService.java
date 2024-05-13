package org.example.javafxcoolweatherapp.api.openweather;

import org.example.javafxcoolweatherapp.api.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.model.GeoData;
import org.example.javafxcoolweatherapp.data.DataObjectsJSONParser;

import java.io.IOException;

public class GeoAPIService extends AbstractCacheableSimpleAPIService<GeoData> {
    public GeoAPIService(String APIKey) {
        super(APIKey, "open-weather-geo-cache");
    }

    @Override
    protected String getResponseByURLImpl(String parameter) throws IOException {
        return urlManager.getData(String.format(
                "http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", parameter, APIKey
        ));
    }

    @Override
    protected GeoData parseJSONResponseImpl(String data) throws IOException {
        return DataObjectsJSONParser.parseGeoData(data);
    }
}
