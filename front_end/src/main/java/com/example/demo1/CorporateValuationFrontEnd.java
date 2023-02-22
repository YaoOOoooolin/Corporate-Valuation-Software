package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CorporateValuationFrontEnd extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CorporateValuationFrontEnd.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 875, 800);
        stage.setTitle("Corporate Valuation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}