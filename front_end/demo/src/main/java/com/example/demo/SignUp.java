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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TextField VerifiCode;

    @FXML
    private ImageView code_id;

    String code;
    int num = 0;
    @FXML
    void ChangeImg() throws  InterruptedException {
        num++;
        if (num >= 10){
            num = 1;
        }
        String name = "code"+num+".jpg";
        Image image;
        try {
            code = CheckCodeUtil.Image(num,name);
            Thread.sleep(500);
            image = new Image(SignUp.class.getResource(name).toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        code_id.setImage(image);

    }


    @FXML
    void SignUpCheck(){
        String code = VerifiCode.getText();
        if (!code.equals(code)){
        }
    }
}
