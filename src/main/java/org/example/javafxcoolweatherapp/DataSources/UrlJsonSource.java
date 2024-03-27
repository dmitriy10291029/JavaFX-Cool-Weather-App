package org.example.javafxcoolweatherapp.DataSources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlJsonSource implements JsonSource {
    static private final String API_KEY = "";
    static private final String WEATHER_SERVICE_URL = "http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=";

    private String getStringUrlContent(String urlAddress) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlAddress);
            URLConnection urlConnection = url.openConnection();
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append('\n');
                }
            }
        } catch (IOException e) {
            return null;
        }

        return content.toString();
    }


}
