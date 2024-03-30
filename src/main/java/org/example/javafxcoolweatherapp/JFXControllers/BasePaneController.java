package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.CurrentForecastAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.GeoAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.HourlyForecastAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.ThreeHourForecastAPIService;
import org.example.javafxcoolweatherapp.DataObjects.CurrentForecast;
import org.example.javafxcoolweatherapp.DataObjects.HourlyForecast;
import org.example.javafxcoolweatherapp.DataObjects.ThreeHourForecast;

import java.io.IOException;

public class BasePaneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String APIKey = "";
        try {
            GeoAPIService geoAPI = new GeoAPIService(APIKey);
            ThreeHourForecastAPIService threeHourforecastAPIService =
                    new ThreeHourForecastAPIService(APIKey, geoAPI);
            ThreeHourForecast threeHourforecast = threeHourforecastAPIService.getData("Moscow");
            System.out.println(threeHourforecast);

            CurrentForecastAPIService currentForecastAPIService =
                    new CurrentForecastAPIService(APIKey, geoAPI);
            CurrentForecast currentForecast = currentForecastAPIService.getData("Moscow");
            System.out.println(currentForecast);

            welcomeText.setText("Успех");

        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText(e.getMessage());
        }
    }
}