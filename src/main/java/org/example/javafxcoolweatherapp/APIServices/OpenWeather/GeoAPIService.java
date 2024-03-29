package org.example.javafxcoolweatherapp.APIServices.OpenWeather;

import org.example.javafxcoolweatherapp.APIServices.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
}
