package org.example.javafxcoolweatherapp.APIServices.OpenWeather;

import org.example.javafxcoolweatherapp.DataObjects.GeoDataObject;
import org.example.javafxcoolweatherapp.DataObjects.HourlyForecastDataObject;
import org.example.javafxcoolweatherapp.DataObjects.TimeStampDataObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataObjectsJSONParser {
    private static final JSONParser parser = new JSONParser();

    public static GeoDataObject parseGeoData(String data) throws IOException {
        if (data == null) {
            throw new IOException("Invalid data for parsing.");
        }

        try {
            JSONArray citiesArray = (JSONArray) parser.parse(data);
            JSONObject firstCity = (JSONObject) citiesArray.get(0);

            return new GeoDataObject(
                    (double) firstCity.get("lat"),
                    (double) firstCity.get("lon")
            );

        } catch (Exception e) {
            throw new IOException("Invalid data for parsing.", e);
        }
    }

    public static HourlyForecastDataObject parseHourlyForecastData(String data)
            throws IOException {

        if (data == null) {
            throw new IOException("Invalid data for parsing.");
        }
        try {
            JSONObject fullResponse = (JSONObject) parser.parse(data);
            JSONArray timeStampsArray = (JSONArray) fullResponse.get("list");

            List<TimeStampDataObject> tsList = new ArrayList<>();
            for (Object item : timeStampsArray) {
                JSONObject timeStamp = (JSONObject) item;
                JSONObject main = (JSONObject) timeStamp.get("main");
                JSONObject weather = (JSONObject)((JSONArray) timeStamp.get("weather")).get(0);
                JSONObject wind = (JSONObject) timeStamp.get("wind");

                TimeStampDataObject timeStampDataObject = new TimeStampDataObject(
                        (long) timeStamp.get("dt"),
                        (double) main.get("feels_like"),
                        (double) main.get("pressure"),
                        (double) main.get("humidity"),
                        (String) weather.get("description"),
                        (double) wind.get("speed"),
                        (long) timeStamp.get("sunrise"),
                        (long) timeStamp.get("sunset")
                );
            }

            return new HourlyForecastDataObject(tsList);

        } catch (Exception e) {
            throw new IOException("Invalid data for parsing.", e);
        }
    }
}
