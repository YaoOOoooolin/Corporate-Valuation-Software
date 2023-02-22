package com.example.grpteam14;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {


        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-image: url(" + "file:src/sky.jpg" + "); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-color:  transparent;");

        /*
        LinearGradient linearGradient2 = new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.REFLECT, new Stop[] {
                new Stop(0, Color.rgb(135,206,250)),
                new Stop(1, Color.rgb(0,0,255)),
                new Stop(0, Color.rgb(135,206,250))
        });
        Background background=new Background(new BackgroundFill(linearGradient2,null,null));

        borderPane.setBackground(background);


         */
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
        AnchorPane anchorPane=new AnchorPane();
        TitledPane tp1=new TitledPane("Title dPane 1",new Button("Botton 1"));
        TitledPane tp2=new TitledPane("TP2", new Button("Btn 2"));
        left.getChildren().addAll(tp1,tp2);

        borderPane.setLeft(left);

        GridPane gridPane = new GridPane();
        gridPane.setMinWidth(400);
        gridPane.setMinHeight(240);

        AnchorPane midAnchorPane=new AnchorPane();
        TabPane tabPane=new TabPane();
        //加颜色给tabPane
        //tabPane.setStyle();
        tabPane.setPrefHeight(300);
        tabPane.setPrefWidth(300);
        Tab tab1=new Tab("tab1",new Button("tab1"));
        Tab tab2=new Tab("tab2",new Button("tab2"));
        TextField text1Tab1=new TextField();
        TextField text2Tab1=new TextField();
        Text t = new Text();
        t.setCache(true);
        t.setX(10.0);
        t.setY(70.0);
        t.setFill(Color.BLUE);
        t.setText("JavaFX");
        t.setFont(Font.font(null, FontWeight.BOLD, 32));
        VBox vboxTab1=new VBox(10);
        vboxTab1.setPadding(new Insets(10));
        vboxTab1.getChildren().addAll(t,text1Tab1,text2Tab1);

        VBox vboxTab2=new VBox(new TextField(),new TextField());
        tab1.setContent(vboxTab1);
        tab2.setContent(vboxTab2);
        tab1.setClosable(false);
        tab2.setClosable(false);

        tabPane.getTabs().addAll(tab1,tab2);

        gridPane.getChildren().add(tabPane);


        borderPane.setCenter(gridPane);
        borderPane.setRight(new Button("RightTest"));

        system.setOnAction(e->{
            tabPane.getSelectionModel().select(tab2);

        });
        menu2.setOnAction(e->{
            Background background3=new Background(new BackgroundFill(Color.MEDIUMVIOLETRED,null,null));
            gridPane.setBackground(background3);
            final TextField name = new TextField();
            name.setPromptText("2.");
            name.setPrefColumnCount(10);
            name.getText();
            gridPane.setConstraints(name, 0, 0);
            gridPane.getChildren().add(name);
        });
        menu3.setOnAction(e->{
            Background background3=new Background(new BackgroundFill(Color.WHITE,null,null));
            gridPane.setBackground(background3);
            final TextField name = new TextField();
            name.setPromptText("3.");
            name.setPrefColumnCount(10);
            name.getText();
            gridPane.setConstraints(name, 0, 0);
            gridPane.getChildren().add(name);
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