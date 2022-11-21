

package com.example.demo1;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;

public class HelloController {


    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private TabPane tabPane;

    @FXML
    private Button test;

    @FXML
    void testNavigate(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        System.out.println("ssssssssssss");
        alert.setContentText("点了");
        alert.show();
        tabPane.getSelectionModel().select(tab2);
    }

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private TitledPane RandDYes;

    @FXML
    private Button RandDYes2;

    @FXML
    void SheetRandD(ActionEvent event) {
        tabPane.getSelectionModel().select(tab2);
    }

    @FXML
    private void initialize() {
        //ObservableList<String> observableList = FXCollections.observableArrayList("111", "222", "333");
        //combo1.setItems(observableList);
        combo1.getItems().addAll(
                "jacob.smith@example.com",
                "isabella.johnson@example.com",
                "ethan.williams@example.com",
                "emma.jones@example.com",
                "michael.brown@example.com");
        RandDYes.setExpanded(false);
    }
}
