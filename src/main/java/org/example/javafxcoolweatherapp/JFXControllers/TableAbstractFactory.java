package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import org.example.javafxcoolweatherapp.APIServices.AbstractCacheableSimpleAPIService;
import org.example.javafxcoolweatherapp.DataObjects.TimeStamp;

import java.io.File;
import java.util.ArrayList;

public final class TableAbstractFactory {
    public static ArrayList<HourlyTableRow> createHourlyTable(final GridPane hourlyGridPane) {
        Font font = new Font(18.0);
        ArrayList<HourlyTableRow> table = new ArrayList<>();

        for (int row = 0; row < 8; row++) {
            Label time = new Label(Formatter.formatHour(row * 3));
            Label temp = new Label();

            time.setFont(font);
            temp.setFont(font);

            hourlyGridPane.add(time, 0, row);
            hourlyGridPane.add(temp, 1, row);
            table.add(new HourlyTableRow(time, temp));
        }

        return table;
    }

    public static ArrayList<DetailsTableRow> createDetailsTable(final GridPane detailsGridPane) {
        Font font = new Font(12.0);
        ArrayList<DetailsTableRow> table = new ArrayList<>();
        String[] paramNameList = {"Temperature", "Feels like", "Pressure", "Humidity", "Wind speed"};

        for (int row = 0; row < paramNameList.length; row++) {
            Label param = new Label(paramNameList[row] + ": ");
            Label value = new Label();

            param.setFont(font);
            value.setFont(font);

            detailsGridPane.add(param, 0, row);
            detailsGridPane.add(value, 1, row);
            table.add(new DetailsTableRow(param, value));
        }

        return table;
    }

    public static ArrayList<RecentCitiesTableRow> createRecentCitiesTable(
            final GridPane recentCitiesGridPane,
            final AbstractCacheableSimpleAPIService<TimeStamp> apiService)
    {
        return null;
    }
}
