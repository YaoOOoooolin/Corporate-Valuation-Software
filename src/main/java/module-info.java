module com.example.grpteam14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grpteam14 to javafx.fxml;
    exports com.example.grpteam14;
}