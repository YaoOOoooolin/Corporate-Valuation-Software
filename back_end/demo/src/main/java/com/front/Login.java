/**

 * This class is the controller class of the loginApplication class.
 * In this class, The username and password entered by the user are detected and the user is allowed to select the csv path.
 * If the values are correct, it will junp to the next page, otherwise, it will show a prompt at the top.
 * @author [Zihao ZHANG]
 * @version [V1.0]
 * @since [2023/2/11]
 */
package com.front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Login {

    @FXML
        private TextField password_id;

    public boolean getPassword_id() {
        String userName = username_id.getText();
        if (!userName.equals("admin")){
            wrongUsernameOrPassword_id.setVisible(true);
            return false;
        }
        return true;
    }

        @FXML
        private TextField username_id;

        public boolean getUsername_id() {
            String userName = password_id.getText();
            if (!userName.equals("123456")){
                wrongUsernameOrPassword_id.setVisible(true);
                return false;
            }
            return true;
        }


    @FXML
    private Button SignIn_id;

    @FXML
    private Button SignUp_id;

    @FXML
    void ToCal(ActionEvent event) throws IOException{
        boolean userName = getUsername_id();
        boolean passWord = getPassword_id();
        if (userName){
            if (passWord){
                switchToGame(event);
            }
        }
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("signUp.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 330);
        stage.setTitle("SignUp");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("The Story");
        stage.show();
    }

    @FXML
        private Label wrongUsernameOrPassword_id;

    public String getPath() {
        return path;
    }
    static String filepath;
    String path;

    public void SelectFile(ActionEvent actionEvent) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {

            path = selectedFile.getAbsolutePath();
            System.out.println(path);
            filepath = path;
        }
    }


}
