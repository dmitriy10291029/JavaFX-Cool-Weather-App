module org.example.javafxcoolweatherapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxcoolweatherapp to javafx.fxml;
    //exports org.example.javafxcoolweatherapp;
    exports org.example.javafxcoolweatherapp.JFXControllers;
    opens org.example.javafxcoolweatherapp.JFXControllers to javafx.fxml;
    exports org.example.javafxcoolweatherapp;
}