package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.ForecastAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.GeoAPIService;
import org.example.javafxcoolweatherapp.APIServices.SimpleAPIService;
import org.example.javafxcoolweatherapp.DataObjects.HourlyForecastDataObject;

public class BasePaneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        ForecastAPIService forecastAPIService = new ForecastAPIService("");
        HourlyForecastDataObject forecast = forecastAPIService.getData("Moscow");
        if (forecast == null) {
            welcomeText.setText("Ошибка");
        } else {
            System.out.println(forecast);
            welcomeText.setText("Успех");
        }
    }
}