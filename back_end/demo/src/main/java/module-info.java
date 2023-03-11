module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires itextpdf;


    opens com.front to javafx.fxml;
    exports com.front;
}