package com.front;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;

import javafx.concurrent.Worker.State;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;


public class Echarts extends Application{
    JSObject jsWindow;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Web View Sample");
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        Button button = new Button("OK");
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setPrefWidth(100);
        button.setPrefHeight(50);

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = jsWindow.call("getMyData").toString();
                String[] dataArray = result.split(",");
                double[] values = new double[10];

                for (int i = 0; i < dataArray.length; i += 2) {
                    int index = Integer.parseInt(dataArray[i]) - 1;
                    double value = Double.parseDouble(dataArray[i+1]);
                    values[index] = value;
                }

                double value1 = values[0];
                double value2 = values[1];
                double value3 = values[2];
                double value4 = values[3];
                double value5 = values[4];
                double value6 = values[5];
                double value7 = values[6];
                double value8 = values[7];
                double value9 = values[8];
                double value10 = values[9];

                System.out.println(value1);
                System.out.println(value2);
                System.out.println(value3);
                System.out.println(value4);
                System.out.println(value5);
                System.out.println(value6);
                System.out.println(value7);
                System.out.println(value8);
                System.out.println(value9);
                System.out.println(value10);

                Platform.exit();
            }
        });


        webEngine.load(Objects.requireNonNull(this.getClass().getResource("drag.html")).toExternalForm());
        root.getChildren().add(webView);
        root.getChildren().add(button);


        Scene scene = new Scene(root, 825, 550, Color.web("lightgray"));
        stage.setScene(scene);

        webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends State> ov, State oldState, State newState) -> {
            MyBridge myBridge = new MyBridge();
            myBridge.setBaseYear(5);
            myBridge.setTerminalYear(50);
            ArrayList<Double> myArray = myBridge.getValue(10);

            if (newState == State.SUCCEEDED) {
                try {
                    // Read the contents of the JS file
                    String script = new String(Files.readAllBytes(Paths.get("back_end/demo/src/main/resources/com/front/index.js")));
                    webEngine.executeScript(script);
                    // Execute the JS file in the WebView
                    jsWindow = (JSObject) webEngine.executeScript("window");
                    jsWindow.setMember("javaArray", myArray);
                    webEngine.executeScript("useJavaArray(javaArray)");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                stage.show();


            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
