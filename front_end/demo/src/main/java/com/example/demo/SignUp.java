package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {
    @FXML
    private TextField password_id;

    @FXML
    private TextField username_id;


    @FXML Button SignIn_id;

    @FXML Button Quit_id;

    @FXML Button SignUp_id;

    @FXML Button SignUpCheck_id;

    @FXML
    void ToCal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 600, 330);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void Quit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void SignUpCheck(){

    }
}