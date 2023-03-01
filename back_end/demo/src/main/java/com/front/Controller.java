package com.front;
import com.back.example.InputSheet.BasicData;
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
/*
* b标签与a标签一一对应
* 日期行业等先不用输入，只输入数据相关*/
    public DatePicker B1;
    public TextField B2;
    public TextField B8;
    public TextField B9;
    public TextField B10;
    public TextField B11;
    public TextField B12;
    public TextField B15;
    public TextField B16;
    public TextField B17;
    public TextField B18;
    public TextField B19;
    public TextField B20;
    public CheckBox B13Yes;
    public CheckBox B13No;
    public TextField B21;
    public TextField B23;
    public TextField B24;
    public TextField B25;
    public TextField B26;
    public TextField B27;
    public TextField B28;
    public TextField B30;
    public TextField B31;
    public TextField B34;
    public TextField B35;
    public TextField B36;
    public TextField B37;
    public CheckBox B33Yes;
    public CheckBox B33No;
    public TextField B42;
    public TextField B45;
    public CheckBox B41Yes;
    public CheckBox B41No;
    public CheckBox B44Yes;
    public CheckBox B44No;
    public CheckBox B47Yes;
    public CheckBox B47No;
    public TextField B49;
    public TextField B48;
    public TextField B50;
    public TextField B55;
    public TextField B59;
    public CheckBox B54Yes;
    public CheckBox B54No;
    public CheckBox B58Yes;
    public CheckBox B58No;
    public CheckBox B60Yes;
    public CheckBox B60No;
    public CheckBox B63Yes;
    public CheckBox B63No;
    public TextField B61;
    public TextField B64;
    public TextField B65;
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
    private void B13CheckYes(){
        //b 为YES 和 NO 选择的返回值， yes为true  no为false
        boolean b = CheckBoxYes(B13Yes, B13No);
    }

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
        //submit 按钮进行读入 后进行计算
        BasicData basicData = new BasicData();
        basicData.setRevenues_A8(Float.parseFloat(B8.getText()));
        System.out.println(basicData.getRevenues_A8());
        basicData.setOperating_ncome_or_EBIT_A9(Float.parseFloat(B9.getText()));

        Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 1094, 800);
        stage.setTitle("Result");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void B13CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B13Yes, B13No);
    }

    public void B33CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B33Yes, B33No);
    }

    public void B33CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B33Yes, B33No);
    }

    public void B41CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B41Yes, B41No);
    }

    public void B44CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B44Yes, B44No);
    }

    public void B41CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B41Yes, B41No);
    }

    public void B44CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B44Yes, B44No);
    }

    public void B47CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B47Yes, B47No);
    }

    public void B47CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B47Yes, B47No);
    }

    public void B54CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B54Yes, B54No);
    }

    public void B54CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B54Yes, B54No);
    }

    public void B58CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B58Yes, B58No);
    }

    public void B58CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B58Yes, B58No);
    }

    public void B60CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B60Yes, B60No);
    }

    public void B60CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B60Yes, B60No);
    }

    public void B63CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B63Yes, B63No);
    }

    public void B63CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B63Yes, B63No);
    }

    public boolean CheckBoxYes(CheckBox yes, CheckBox no){
        no.setDisable(yes.isSelected());
        return true;
    }

    public boolean CheckBoxNo(CheckBox yes, CheckBox no){
        yes.setDisable(no.isSelected());
        return false;
    }
}
