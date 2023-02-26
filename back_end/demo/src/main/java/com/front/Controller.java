package com.front;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.stage.Stage;
        import java.io.IOException;
        import java.util.Locale;

public class Controller {
    @FXML
    private Button TPtoInput1;

    @FXML
    private Button TPtoInput2;

    @FXML
    private Button TPtoInput3;

    @FXML
    private Button TPtoInput4;

    @FXML
    private Button TPtoInput5;
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab5;

    @FXML
    private Tab tab6;
    @FXML
    private Tab tab3;
    @FXML
    private Tab tab4;

    @FXML
    private TabPane tabPane;


    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private Button submit_id;



    @FXML
    private void initialize() {
        //ObservableList<String> observableList = FXCollections.observableArrayList("111", "222", "333");
        //combo1.setItems(observableList);
        comboBox1.getItems().addAll(
                "United States",
                "United Kingdom",
                "China",
                "Denmark",
                "Japan");

        Locale.setDefault(Locale.ENGLISH);
    }

    @FXML
    void ToTab1(ActionEvent event) {
        tabPane.getSelectionModel().select(tab1);
    }

    @FXML
    void ToTab2(ActionEvent event) {
        tabPane.getSelectionModel().select(tab2);
    }

    @FXML
    void ToTab3(ActionEvent event) {
        tabPane.getSelectionModel().select(tab3);
    }

    @FXML
    void ToTab4(ActionEvent event) {
        tabPane.getSelectionModel().select(tab4);
    }
    @FXML
    void ToTab5(ActionEvent event) {tabPane.getSelectionModel().select(tab5);
    }
    @FXML
    void ToTab6(ActionEvent event){
        tabPane.getSelectionModel().select(tab6);
    }
    @FXML
    void result(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 850, 800);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
