module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.web;
    requires jdk.jsobject;
    requires com.opencsv;


    opens com.front to javafx.fxml;
    exports com.front;
}