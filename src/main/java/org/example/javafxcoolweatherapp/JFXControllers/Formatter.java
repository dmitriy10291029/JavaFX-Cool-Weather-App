package org.example.javafxcoolweatherapp.JFXControllers;

import org.example.javafxcoolweatherapp.DataObjects.TimeStamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Formatter {
    public static String formatTemp(double temp) {
        long roundAvg = Math.round(temp);

        return (roundAvg > 0 ? "+" : "") + roundAvg + "°";
    }

    public static String getDateOfThreeHour(final TimeStamp timeStamp) {
        LocalDate date = LocalDate.ofInstant(Instant.ofEpochSecond(
                        timeStamp.getForecastTimeUnixUTC()),
                ZoneId.systemDefault()
        );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");

        return formatter.format(date);
    }

    public static String formatHour(int hour) {
        if (hour < 10) {
            return "0" + hour + ":00";
        } else {
            return hour + ":00";
        }
    }

    public static String formatPressure(int pressure) {
        return String.valueOf(pressure) + " HPa";
    }

    public static String formatHumidity(int humidity) {
        return String.valueOf(humidity) + "%";
    }

    public static String formatWindSpeed(double speed) {
        return String.valueOf(speed) + " m/s";
    }
}
