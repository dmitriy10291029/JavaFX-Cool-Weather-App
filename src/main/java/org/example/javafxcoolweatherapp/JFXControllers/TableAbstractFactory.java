package org.example.javafxcoolweatherapp.JFXControllers;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

public final class TableAbstractFactory {
    public static ArrayList<HourlyTableRow> createHourlyTable(final GridPane hourlyGridPane) {
        Font font = new Font(20.0);
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
        return null;
    }

    public static ArrayList<RecentCitiesTableRow> createRecentCitiesTable(final GridPane recentCitiesGridPane) {
        return null;
    }
}
