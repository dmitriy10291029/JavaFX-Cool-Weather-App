package org.example.javafxcoolweatherapp.APIServices.OpenWeather;

import org.example.javafxcoolweatherapp.DataObjects.GeoData;
import org.example.javafxcoolweatherapp.DataObjects.TimeStamp;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataObjectsJSONParser {
    private static final JSONParser parser = new JSONParser();

    public static GeoData parseGeoData(String data) throws IOException {
        if (data == null) {
            throw new IOException("Invalid data for parsing.");
        }

        try {
            JSONArray citiesArray = (JSONArray) parser.parse(data);
            JSONObject firstCity = (JSONObject) citiesArray.get(0);

            return new GeoData(
                    (double) firstCity.get("lat"),
                    (double) firstCity.get("lon")
            );

        } catch (Exception e) {
            throw new IOException("Invalid data for parsing.", e);
        }
    }

    public static List<TimeStamp> parseTimeStampsList(String data)
            throws IOException {

        if (data == null) {
            throw new IOException("Invalid data for parsing.");
        }
        try {
            JSONObject fullResponse = (JSONObject) parser.parse(data);
            JSONArray timeStampsArray = (JSONArray) fullResponse.get("list");

            List<TimeStamp> tsList = new ArrayList<>();
            for (Object item : timeStampsArray) {
                JSONObject timeStamp = (JSONObject) item;
                JSONObject main = (JSONObject) timeStamp.get("main");
                JSONObject weather = (JSONObject)((JSONArray) timeStamp.get("weather")).get(0);
                JSONObject wind = (JSONObject) timeStamp.get("wind");

                long forecastTimeUnixUTC    = (long)        timeStamp.get("dt");
                double feelsLikeCelsius     = (double)      main.get("feels_like");
                int pressureHPa             = (int) (long)  main.get("pressure");
                int humidityPercents        = (int) (long)  main.get("humidity");
                String weatherDescription   = (String)      weather.get("description");
                double windSpeedMetersSec   = (double)      wind.get("speed");

                tsList.add(new TimeStamp(
                                forecastTimeUnixUTC,
                                feelsLikeCelsius,
                                pressureHPa,
                                humidityPercents,
                                weatherDescription,
                                windSpeedMetersSec
                ));
            }

            return tsList;

        } catch (Exception e) {
            throw new IOException("Invalid data for parsing.", e);
        }
    }
}
