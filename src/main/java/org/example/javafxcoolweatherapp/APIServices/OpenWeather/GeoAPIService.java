package org.example.javafxcoolweatherapp.APIServices.OpenWeather;

import org.example.javafxcoolweatherapp.APIServices.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;

public class GeoAPIService extends AbstractCacheableSimpleAPIService<GeoDataObject> {
    public GeoAPIService(String APIKey) {
        super(APIKey, "open-weather-geo-cache");
    }

    @Override
    protected String getResponseByURL(String parameter) {
        return urlManager.getData(String.format(
                "http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", parameter, APIKey
        ));
    }

    @Override
    protected GeoDataObject parseJSONResponse(String data) {
        return DataObjectsJSONParser.parseGeoData(data);
    }
}
