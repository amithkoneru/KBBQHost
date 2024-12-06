module com.example.kbbqhost {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kbbqhost to javafx.fxml;
    exports com.kbbqhost.gui;
    exports com.kbbqhost.controller;
    exports com.kbbqhost.model;
}