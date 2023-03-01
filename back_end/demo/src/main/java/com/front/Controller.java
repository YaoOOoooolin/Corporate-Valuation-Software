package com.front;
import com.back.example.InputSheet.BasicData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    public CheckBox B52Yes;
    public CheckBox B52No;
    public Text B50Text;
    public Text B48Text;
    public Text B49Text;
    public Text B45Text;
    public Text B42Text;
    public Text B55Text;
    public Text B61Text;
    public Text B64Text;
    public Text B65Text;
    public Text B59Text;
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
    void result(ActionEvent event){
        //submit 按钮进行读入 后进行计算
        try{
        BasicData basicData = new BasicData();
        basicData.setRevenues_A8(Float.parseFloat(B8.getText()));
        basicData.setOperating_ncome_or_EBIT_A9(Float.parseFloat(B9.getText()));
        Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 1094, 800);
        stage.setTitle("Result");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please fill in every single component");
            alert.show();
            blankCheck(B8, B9, B2, B10, B11, B12, B15, B16, B17, B18, B19, B20, B21, B23, B24, B25, B26);
            blankCheck(B27, B28, B30, B31, B34, B35, B36, B37, B42, B45, B49, B48, B50, B55, B59, B61, B64);
            isBlank(B65);
            isBlank(B13Yes,B13No);
            isBlank(B33Yes,B33No);
            isBlank(B41Yes,B41No);
            isBlank(B44Yes,B44No);
            isBlank(B47Yes,B47No);
            isBlank(B54Yes,B54No);
            isBlank(B58Yes,B58No);
            isBlank(B60Yes,B60No);
            isBlank(B63Yes,B63No);
            isBlank(B52Yes,B52No);
            throw new RuntimeException(e);
        }
    }

    private void blankCheck(TextField b27, TextField b28, TextField b30, TextField b31, TextField b34, TextField b35, TextField b36, TextField b37, TextField b42, TextField b45, TextField b49, TextField b48, TextField b50, TextField b55, TextField b59, TextField b61, TextField b64) {
        isBlank(b27);
        isBlank(b28);
        isBlank(b30);
        isBlank(b31);
        isBlank(b34);
        isBlank(b35);
        isBlank(b36);
        isBlank(b37);
        isBlank(b42);
        isBlank(b45);
        isBlank(b49);
        isBlank(b48);
        isBlank(b50);
        isBlank(b55);
        isBlank(b59);
        isBlank(b61);
        isBlank(b64);
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
        isVisible(B42Text,B42,B41Yes.isSelected());
    }

    public void B44CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B44Yes, B44No);
        isVisible(B45Text,B45,B44Yes.isSelected());
    }

    public void B41CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B41Yes, B41No);
    }

    public void B44CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B44Yes, B44No);
    }

    public void B47CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B47Yes, B47No);
        isVisible(B48Text,B48,B47Yes.isSelected());
        isVisible(B49Text,B49,B47Yes.isSelected());
        isVisible(B50Text,B50,B47Yes.isSelected());
    }

    public void B47CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B47Yes, B47No);
    }

    public void B54CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B54Yes, B54No);
        isVisible(B55Text,B55,B54Yes.isSelected());
    }

    public void B54CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B54Yes, B54No);
    }

    public void B58CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B58Yes, B58No);
        isVisible(B59Text,B59,B58Yes.isSelected());
    }

    public void B58CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B58Yes, B58No);
    }

    public void B60CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B60Yes, B60No);
        isVisible(B61Text,B61,B60Yes.isSelected());
    }

    public void B60CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B60Yes, B60No);
    }

    public void B63CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B63Yes, B63No);
        isVisible(B64Text,B64,B63Yes.isSelected());
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


    public void isVisible(Text t, TextField f,boolean b){
        t.setVisible(b);
        f.setVisible(b);
    }

    public void B52CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B52Yes, B52No);
    }

    public void B52CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B52Yes, B52No);
    }

    public void isBlank(DatePicker c){
        //如果不填写，填写当前电脑日期还是？
    }

    //下拉菜单不选择适配数据库，还是？
    public void isBlank(){

    }
    public void isBlank(TextField c){
        if (c.getText().isEmpty()){
            c.setStyle("-fx-border-color: red;");
        }
    }public void isBlank(CheckBox c,CheckBox d){
        if (!(c.isSelected() & d.isSelected())){
            Parent parent = c.getParent();
            parent.setStyle("-fx-border-color: red;");
        }
    }
}
