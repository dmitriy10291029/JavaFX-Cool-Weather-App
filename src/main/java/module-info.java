module org.example.javafxcoolweatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens org.example.javafxcoolweatherapp to javafx.fxml;
    exports org.example.javafxcoolweatherapp.view;
    opens org.example.javafxcoolweatherapp.view to javafx.fxml;
    exports org.example.javafxcoolweatherapp;
}