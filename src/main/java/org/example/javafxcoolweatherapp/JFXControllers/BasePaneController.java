package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.GeoAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.HourlyForecastAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.ThreeHourForecastAPIService;
import org.example.javafxcoolweatherapp.DataObjects.HourlyForecast;
import org.example.javafxcoolweatherapp.DataObjects.ThreeHourForecast;

import java.io.IOException;

public class BasePaneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String APIKey = "";
        GeoAPIService geoAPI = new GeoAPIService(APIKey);
        ThreeHourForecastAPIService forecastAPIService =
                new ThreeHourForecastAPIService(APIKey, geoAPI);
        try {
            ThreeHourForecast forecast = forecastAPIService.getData("Moscow");
            System.out.println(forecast);
            welcomeText.setText("Успех");

        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText("Ошибка");
        }
    }
}