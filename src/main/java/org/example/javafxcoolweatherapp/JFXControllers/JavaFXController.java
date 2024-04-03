package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.GeoAPIService;
import org.example.javafxcoolweatherapp.APIServices.OpenWeather.ThreeHourForecastAPIService;
import org.example.javafxcoolweatherapp.DataObjects.ThreeHourForecast;
import org.example.javafxcoolweatherapp.DataObjects.TimeStamp;

import java.io.IOException;
import java.util.ArrayList;

public final class JavaFXController {
    final private static String APIKey = "5444a50a846c6b05227cf5d443fa903c";

    final private ThreeHourForecastAPIService threeHourForecastAPIService
            = new ThreeHourForecastAPIService(APIKey, new GeoAPIService(APIKey));

    @FXML
    private GridPane hourlyDetails;
    private ArrayList<HourlyTableRow> hourlyNodeTable;

    @FXML
    private GridPane detailsTable;
    private ArrayList<DetailsTableRow> detailsNodeTable;

    @FXML
    private GridPane recentCitiesTable;
    private ArrayList<RecentCitiesTableRow> recentCitiesNodeTable;

    @FXML
    public void onCitySearchButtonClick() {
        try {
            setDataThreeHour(
                    threeHourForecastAPIService.getDataByURL(cityNameField.getText()));
            errorLabel.setText("");

        } catch (IOException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void setCurrentData(final TimeStamp currentTimeStamp) {
        cityName.setText(cityNameField.getText().toUpperCase());

        temp.setText(Formatter.formatTemp(
                currentTimeStamp.getTempCelsius()));

        feelsLike.setText("Feels like: " + Formatter.formatTemp(
                currentTimeStamp.getFeelsLikeCelsius()));

        weatherDescription.setText(
                currentTimeStamp.getWeatherDescription());

        updateDate.setText(
                Formatter.getDateOfThreeHour(currentTimeStamp));
    }

    private double getAvgTempForThreeHour(int day, final ThreeHourForecast threeHourForecast) {
        double tempSum = 0;
        for (int i = 0; i < 24; i += 3) {
            tempSum += threeHourForecast.getTimeStamp(i, day).getTempCelsius();
        }

        return tempSum / 8;
    }

    private void fillHourlyByThreeHour(final ThreeHourForecast threeHourForecast) {
        if (hourlyNodeTable == null) {
            hourlyNodeTable = TableAbstractFactory.createHourlyTable(hourlyDetails);
        }
        for (int row = 0; row < 8; row++) {
            hourlyNodeTable.get(row).getTemp().setText(Formatter.formatTemp(
                    threeHourForecast.getTimeStamp(row * 3, 0).getTempCelsius()));
        }
    }

    private void fillDetailsByThreeHour(final ThreeHourForecast threeHourForecast) {
        if (detailsNodeTable == null) {
            detailsNodeTable = TableAbstractFactory.createDetailsTable(detailsTable);
        }

        detailsNodeTable.get(0).getValue().setText(Formatter.formatTemp(
                threeHourForecast.getTimeStamp(0).getTempCelsius()));

        detailsNodeTable.get(1).getValue().setText(Formatter.formatTemp(
                threeHourForecast.getTimeStamp(0).getFeelsLikeCelsius()));

        detailsNodeTable.get(1).getValue().setText(Formatter.formatTemp(
                threeHourForecast.getTimeStamp(0).getFeelsLikeCelsius()));

        for (int row = 0; row < 8; row++) {
            hourlyNodeTable.get(row).getTemp().setText(Formatter.formatTemp(
                    threeHourForecast.getTimeStamp(row * 3, 0).getTempCelsius()));
        }
    }

    private void setDataThreeHour(final ThreeHourForecast threeHourForecast) {
        setCurrentData(threeHourForecast.getTimeStamp(0));

        fillHourlyByThreeHour(threeHourForecast);

        setDownPaneDay1Data(threeHourForecast);
        setDownPaneDay2Data(threeHourForecast);
        setDownPaneDay3Data(threeHourForecast);
        setDownPaneDay4Data(threeHourForecast);
        setDownPaneDay5Data(threeHourForecast);
    }

    private void setDownPaneDay1Data(final ThreeHourForecast threeHourForecast) {
        int day = 0;
        day1Date.setText(Formatter.getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day1Temp.setText(Formatter.formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day1Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
    }

    private void setDownPaneDay2Data(final ThreeHourForecast threeHourForecast) {
        int day = 1;
        day2Date.setText(Formatter.getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day2Temp.setText(Formatter.formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day2Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
    }

    private void setDownPaneDay3Data(final ThreeHourForecast threeHourForecast) {
        int day = 2;
        day3Date.setText(Formatter.getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day3Temp.setText(Formatter.formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day3Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
    }

    private void setDownPaneDay4Data(final ThreeHourForecast threeHourForecast) {
        int day = 3;
        day4Date.setText(Formatter.getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day4Temp.setText(Formatter.formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day4Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
    }

    private void setDownPaneDay5Data(final ThreeHourForecast threeHourForecast) {
        int day = 4;
        day5Date.setText(Formatter.getDateOfThreeHour(threeHourForecast.getTimeStamp(0, day)));
        day5Temp.setText(Formatter.formatTemp(getAvgTempForThreeHour(day, threeHourForecast)));
        day5Desc.setText(threeHourForecast.getTimeStamp(0, day).getWeatherDescription());
    }

    @FXML
    private TextField cityNameField;
    @FXML
    private Label errorLabel;

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
}