package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.GeoAPIService;
import org.example.javafxcoolweatherapp.APIServices.SimpleAPIService;

public class BasePaneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        GeoAPIService apiService = new GeoAPIService("");
        welcomeText.setText(apiService.getData("Москва").toString());
    }
}