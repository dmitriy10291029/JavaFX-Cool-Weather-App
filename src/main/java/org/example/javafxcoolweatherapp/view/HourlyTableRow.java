package org.example.javafxcoolweatherapp.view;

import javafx.scene.control.Label;

public class HourlyTableRow {
    private final Label time;
    private final Label temp;

    public HourlyTableRow(Label time, Label temp) {
        this.time = time;
        this.temp = temp;
    }

    public Label getTime() {
        return time;
    }

    public Label getTemp() {
        return temp;
    }
}
