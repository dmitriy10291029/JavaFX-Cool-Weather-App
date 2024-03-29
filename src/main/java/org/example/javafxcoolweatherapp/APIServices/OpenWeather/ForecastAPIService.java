package org.example.javafxcoolweatherapp.APIServices.OpenWeather;

import org.example.javafxcoolweatherapp.APIServices.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;
import org.example.javafxcoolweatherapp.DataObjects.HourlyForecastDataObject;

public class ForecastAPIService extends AbstractCacheableSimpleAPIService<HourlyForecastDataObject> {
    private final GeoAPIService geoAPIService;

    public ForecastAPIService(String APIKey) {
        super(APIKey, "open-weather-forecast-cache");
        geoAPIService = new GeoAPIService(APIKey);
    }

    @Override
    protected String getResponseByURL(String parameter) {
        GeoDataObject geoData = geoAPIService.getData(parameter);
        return urlManager.getData(String.format(
                "https://pro.openweathermap.org/data/2.5/forecast/hourly?lat=%f&lon=%f&appid=%s",
                geoData.getLat(), geoData.getLon(), APIKey
        ));
    }

    @Override
    protected HourlyForecastDataObject parseJSONResponse(String data) {
        return DataObjectsJSONParser.parseHourlyForecastData(data);
    }
}
