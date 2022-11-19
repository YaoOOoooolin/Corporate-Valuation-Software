package com.example.grpteam14;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {


        BorderPane borderPane = new BorderPane();
        Background background=new Background(new BackgroundFill(Color.GRAY,null,null));
        borderPane.setBackground(background);

        HBox top = new HBox();
        Background topBG=new Background(new BackgroundFill(Color.PURPLE,null,null));
        top.setBackground(topBG);
        top.setMinHeight(60);

        Text text = new Text("Demo");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
        top.setAlignment(Pos.CENTER);

        top.getChildren().add(text);
        borderPane.setTop(top);

        VBox left = new VBox(10);
        left.setPadding(new Insets(10));
        Background leftBG=new Background(new BackgroundFill(Color.MEDIUMPURPLE,null,null));
        left.setBackground(leftBG);
        left.setMinWidth(100);
        Button system = new Button("menu 1");
        Button menu2=new Button("menu 2");
        Button menu3=new Button("menu 3");
        Button menu4=new Button("menu 4");
        left.getChildren().addAll(system,menu2,menu3,menu4);

        borderPane.setLeft(left);

        GridPane gridPane = new GridPane();
        Background background2=new Background(new BackgroundFill(Color.LIGHTGRAY,null,null));
        gridPane.setBackground(background2);
        gridPane.setMinWidth(400);
        gridPane.setMinHeight(240);

        borderPane.setCenter(gridPane);
        borderPane.setRight(new Button("RightTest"));

        system.setOnAction(e->{
            Background background3=new Background(new BackgroundFill(Color.GRAY,null,null));
            gridPane.setBackground(background3);

        });
        menu2.setOnAction(e->{
            Background background3=new Background(new BackgroundFill(Color.MEDIUMVIOLETRED,null,null));
            gridPane.setBackground(background3);
        });
        menu3.setOnAction(e->{
            Background background3=new Background(new BackgroundFill(Color.WHITE,null,null));
            gridPane.setBackground(background3);
        });
        menu4.setOnAction(e->{
            Background background3=new Background(new BackgroundFill(Color.VIOLET,null,null));
            gridPane.setBackground(background3);
        });

        /* set bottom
        HBox buttom = new HBox(10);
        buttom.setPadding(new Insets(10));
        buttom.setAlignment(Pos.CENTER);

        buttom.getChildren().addAll(new Button("menu 1"),new Button("menu 2"),new Button("menu 3"),new Button("menu 4"));

        borderPane.setBottom(buttom);

         */

        Scene scene = new Scene(borderPane,600,400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}