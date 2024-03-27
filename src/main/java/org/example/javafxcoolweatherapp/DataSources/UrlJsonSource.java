package org.example.javafxcoolweatherapp.DataSources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlJsonSource implements JsonSource {

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
