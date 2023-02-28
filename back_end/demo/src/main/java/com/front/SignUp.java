package com.front;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
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
    void Quit(ActionEvent event) throws IOException {
        ChangeImg();
        Platform.exit();
    }

    @FXML
    private TextField VerifiCode;

    @FXML
    private ImageView code_id;

    String code;
    @FXML
    void ChangeImg() throws IOException {
        String name = "code.jpg";
        code = CheckCodeUtil.Image();
        FileInputStream fis = new FileInputStream("back_end/demo/src/main/resources/com/front/" + name);
        Image image = new Image(fis);
        code_id.setImage(image);
        System.out.println(code);
    }
    @FXML
    private Text VerificationCodeError_id;

    @FXML
    void SignUpCheck(){
        String inputCode = VerifiCode.getText();
        inputCode = inputCode.toUpperCase();
        if (!code.equals(inputCode)){
            VerificationCodeError_id.setVisible(true);
        }else {
            VerificationCodeError_id.setVisible(false);
        }
    }
    @FXML
    public void initialize() {
        try {
            ChangeImg();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
