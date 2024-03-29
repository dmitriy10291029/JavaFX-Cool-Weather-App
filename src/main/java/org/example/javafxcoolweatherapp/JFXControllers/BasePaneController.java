package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.javafxcoolweatherapp.APIServices.OpenWeatherForecastAPIService;

public class BasePaneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        OpenWeatherForecastAPIService apiService = new OpenWeatherForecastAPIService("");
        welcomeText.setText(apiService.getGeoData("Москва").toString());
    }
}