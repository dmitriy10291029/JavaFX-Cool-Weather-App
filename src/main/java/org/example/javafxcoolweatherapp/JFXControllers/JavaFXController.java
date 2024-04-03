package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.GeoAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.ThreeHourForecastAPIService;
import org.example.javafxcoolweatherapp.DataObjects.ThreeHourForecast;
import org.example.javafxcoolweatherapp.DataObjects.TimeStamp;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class JavaFXController {
    @FXML
    private void onCitySearchButtonClick() {
        String APIKey = "";
        try {
            errorLabel.setText("");
            GeoAPIService geoAPI = new GeoAPIService(APIKey);

            ThreeHourForecastAPIService APIService =
                    new ThreeHourForecastAPIService(APIKey, geoAPI);

            setDataThreeHour(APIService.getDataByURL(cityNameField.getText()));

        } catch (IOException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void setDataThreeHour(final ThreeHourForecast threeHourForecast) {
        setCurrentData(threeHourForecast.getTimeStamp(0));
        setDownPaneDay1Data(threeHourForecast);
        setDownPaneDay2Data(threeHourForecast);
        setDownPaneDay3Data(threeHourForecast);
        setDownPaneDay4Data(threeHourForecast);
        setDownPaneDay5Data(threeHourForecast);
    }

    private void setCurrentData(final TimeStamp currentTimeStamp) {
        cityName.setText(cityNameField.getText());

        temp.setText(formatTemp(
                currentTimeStamp.getTempCelsius()));

        feelsLike.setText("Feels like: " + formatTemp(
                currentTimeStamp.getFeelsLikeCelsius()));

        weatherDescription.setText(
                currentTimeStamp.getWeatherDescription());

        updateDate.setText(
                getDateOfThreeHour(currentTimeStamp));
    }

    private double getAvgTempForThreeHour(int day, final ThreeHourForecast threeHourForecast) {
        double tempSum = 0;
        for (int i = 0; i < 24; i += 3) {
            tempSum += threeHourForecast.getTimeStamp(i, day).getTempCelsius();
        }

        return tempSum / 8;
    }

    private String formatTemp(double temp) {
        long roundAvg = Math.round(temp);

        return (roundAvg > 0 ? "+" : "") + roundAvg + "°";
    }

    private String getDateOfThreeHour(final TimeStamp timeStamp) {
        LocalDate date = LocalDate.ofInstant(Instant.ofEpochSecond(
                timeStamp.getForecastTimeUnixUTC()),
                ZoneId.systemDefault()
        );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");

        return formatter.format(date);
    }

    private void setDownPaneDay1Data(final ThreeHourForecast threeHourForecast) {
        int day = 0;
        day1Date.setText(getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day1Temp.setText(formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day1Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
        day1Temp.setAlignment(Pos.CENTER);
        day1Date.setAlignment(Pos.CENTER);
        day1Desc.setAlignment(Pos.CENTER);
    }

    private void setDownPaneDay2Data(final ThreeHourForecast threeHourForecast) {
        int day = 1;
        day2Date.setText(getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day2Temp.setText(formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day2Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
        day2Temp.setAlignment(Pos.CENTER);
        day2Date.setAlignment(Pos.CENTER);
        day2Desc.setAlignment(Pos.CENTER);
    }

    private void setDownPaneDay3Data(final ThreeHourForecast threeHourForecast) {
        int day = 2;
        day3Date.setText(getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day3Temp.setText(formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day3Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
        day3Temp.setAlignment(Pos.CENTER);
        day3Date.setAlignment(Pos.CENTER);
        day3Desc.setAlignment(Pos.CENTER);
    }

    private void setDownPaneDay4Data(final ThreeHourForecast threeHourForecast) {
        int day = 3;
        day4Date.setText(getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day4Temp.setText(formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day4Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
        day4Temp.setAlignment(Pos.CENTER);
        day4Date.setAlignment(Pos.CENTER);
        day4Desc.setAlignment(Pos.CENTER);
    }

    private void setDownPaneDay5Data(final ThreeHourForecast threeHourForecast) {
        int day = 4;
        day5Date.setText(getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day5Temp.setText(formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day5Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
        day5Temp.setAlignment(Pos.CENTER);
        day5Date.setAlignment(Pos.CENTER);
        day5Desc.setAlignment(Pos.CENTER);
    }

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
}