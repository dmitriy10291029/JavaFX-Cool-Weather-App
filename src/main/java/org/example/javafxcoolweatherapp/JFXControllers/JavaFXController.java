package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.CurrentForecastAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.GeoAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.ThreeHourForecastAPIService;
import org.example.javafxcoolweatherapp.DataObjects.CurrentForecast;
import org.example.javafxcoolweatherapp.DataObjects.ThreeHourForecast;

import java.io.IOException;

public final class JavaFXController {
    @FXML
    private TextField cityNameField;
    @FXML
    private Label errorLabel;
    @FXML
    private GridPane recentCitiesTable;

    @FXML
    private Label day1Date;
    @FXML
    private Label day1Temp;
    @FXML
    private Label day1Desc;
    @FXML
    private Label day2Date;
    @FXML
    private Label day2Temp;
    @FXML
    private Label day2Desc;
    @FXML
    private Label day3Date;
    @FXML
    private Label day3Desc;
    @FXML
    private Label day3Temp;
    @FXML
    private Label day4Date;
    @FXML
    private Label day4Temp;
    @FXML
    private Label day4Desc;
    @FXML
    private Label day5Date;
    @FXML
    private Label day5Desc;
    @FXML
    private Label day5Temp;

    @FXML
    private VBox centerPaneVBox;
    @FXML
    private Label cityName;
    @FXML
    private Label temp;
    @FXML
    private Label feelsLike;
    @FXML
    private Label weatherDescription;
    @FXML
    private Label updateDate;

    @FXML
    private GridPane detailsTable;
    @FXML
    private GridPane hourlyDetails;

    @FXML
    private void onCitySearchButtonClick() {
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}