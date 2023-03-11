package com.front;

import com.back.StaticData.InputData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Objects;

public class Controller {
    /*
     * b标签与a标签一一对应
     * 日期行业等先不用输入，只输入数据相关*/
    public static String B19Result;
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
    public TextField B48;
    public TextField B50;
    public TextField B55;
    public TextField B59;
    public CheckBox B54Yes;
    public CheckBox B54No;
    public CheckBox B57Yes;
    public CheckBox B57No;
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
    public CheckBox B49B;
    public CheckBox B49V;
    public Button TPtoInput6;
    public GridPane Sheet1;
    public Button changeButton;
    public GridPane Sheet2;
    public GridPane Sheet4;
    public GridPane Sheet3;
    public GridPane Sheet5;
    public GridPane Sheet6;
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
    private Tab tab7;

    @FXML
    private TabPane tabPane;


    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private ComboBox<String> comboBox3;

    @FXML
    private ComboBox<String> comboBox4;

    @FXML
    private ComboBox<String> comboBox5;

    @FXML
    private Button submit_id;

    @FXML
    private void B13CheckYes() {
        //b 为YES 和 NO 选择的返回值， yes为true  no为false
        boolean b = CheckBoxYes(B13Yes, B13No);
        InputData.setB13(b);
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
                "Japan","HongKong");
        comboBox4.getItems().addAll(
                "United States",
                "United Kingdom",
                "China",
                "Denmark",
                "Japan","HongKong");

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
    void ToTab5(ActionEvent event) {
        tabPane.getSelectionModel().select(tab5);
    }

    @FXML
    void ToTab6(ActionEvent event) {
        tabPane.getSelectionModel().select(tab6);
    }
    public void ToTab7(ActionEvent actionEvent) {
        tabPane.getSelectionModel().select(tab7);
    }

    @FXML
    void result(ActionEvent event) {
        //submit 按钮进行读入 后进行计算
        try {
            InputData.setB8(Double.parseDouble(B8.getText()));
            InputData.setB9(Double.parseDouble(B9.getText()));
            InputData.setB10(Double.parseDouble(B10.getText()));
            InputData.setB11(Double.parseDouble(B11.getText()));
            InputData.setB12(Double.parseDouble(B12.getText()));

            InputData.setB15(Double.parseDouble(B15.getText()));
            InputData.setB16(Double.parseDouble(B16.getText()));
            InputData.setB17(Double.parseDouble(B17.getText()));
            InputData.setB18(Double.parseDouble(B18.getText()));
            InputData.setB19(Double.parseDouble(B19.getText()));
            B19Result = B19.getText();
            InputData.setB20(isPercentage(B20.getText()));
            InputData.setB21(isPercentage(B21.getText()));

            InputData.setB23(isPercentage(B23.getText()));
            InputData.setB24(isPercentage(B24.getText()));
            InputData.setB25(isPercentage(B25.getText()));
            InputData.setB26(isPercentage(B26.getText()));
            InputData.setB27(Double.parseDouble(B27.getText()));
            InputData.setB28(Double.parseDouble(B28.getText()));

            InputData.setB30(isPercentage(B30.getText()));
            InputData.setB31(isPercentage(B31.getText()));

            InputData.setB34(Double.parseDouble(B34.getText()));
            InputData.setB35(Double.parseDouble(B35.getText()));
            InputData.setB36(Double.parseDouble(B36.getText()));
            InputData.setB37(isPercentage(B37.getText()));

            InputData.setB42(isPercentage(B42.getText()));

            InputData.setB45(isPercentage(B45.getText()));
            InputData.setB48(isPercentage(B48.getText()));
            if (B49B.isSelected()){
                InputData.setB49("B");
            } else if (B49V.isSelected()) {
                InputData.setB49("V");
            }

            InputData.setB50(isPercentage(B50.getText()));

            InputData.setB55(Double.parseDouble(B55.getText()));
            InputData.setB58(isPercentage(B59.getText()));
            InputData.setB61(isPercentage(B61.getText()));
            InputData.setB64(Double.parseDouble(B64.getText()));
            InputData.setB65(isPercentage(B65.getText()));

            Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            Scene scene = new Scene(root, 1094, 800);
            stage.setTitle("Result");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            blankCheck(B8, B9, B2, B10, B11, B12, B15, B16, B17, B18, B19, B20, B21, B23, B24, B25, B26);
            blankCheck(B27, B28, B30, B31, B34, B35, B36, B37, B42, B45, B48, B50, B55, B59, B61, B64,B65);
            isBlank(B13Yes, B13No);
            isBlank(B33Yes, B33No);
            isBlank(B41Yes, B41No);
            isBlank(B44Yes, B44No);
            isBlank(B47Yes, B47No);
            isBlank(B54Yes, B54No);
            isBlank(B57Yes, B57No);
            isBlank(B60Yes, B60No);
            isBlank(B63Yes, B63No);
            isBlank(B52Yes, B52No);
            isBlank(B49B,B49V,B47Yes.isSelected());
            Alert();
            throw new RuntimeException(e);
        }
    }

    private void isBlank(CheckBox c, CheckBox d, boolean selected) {
        Parent parent = c.getParent();
        if (selected){
        parent = c.getParent();
        if (!(c.isSelected() | d.isSelected())) {
            parent.setStyle("-fx-border-color: red;");
        }else {
            parent.setStyle("-fx-border-color: rgb(230, 230, 230)");
        }
        }else {
            parent.setStyle("");
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
        InputData.setB13(b);
    }

    public void B33CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B33Yes, B33No);
        InputData.setB33(b);
    }

    public void B33CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B33Yes, B33No);
        InputData.setB33(b);
    }

    public void B41CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B41Yes, B41No);
        isVisible(B42Text, B42, B41Yes.isSelected());
        InputData.setB41(b);
    }

    public void B44CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B44Yes, B44No);
        isVisible(B45Text, B45, B44Yes.isSelected());
        InputData.setB44(b);
    }

    public void B41CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B41Yes, B41No);
        InputData.setB41(b);
        B42.setText("0");
    }

    public void B44CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B44Yes, B44No);
        InputData.setB44(b);
        B45.setText("0");
    }

    public void B47CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B47Yes, B47No);
        isVisible(B48Text, B48, B47Yes.isSelected());
        isVisible(B49Text,B49B, B49V, B47Yes.isSelected());
        isVisible(B50Text, B50, B47Yes.isSelected());
        InputData.setB47(b);
    }

    public void B47CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B47Yes, B47No);
        InputData.setB47(b);
        B48.setText("0");
        B49B.setSelected(true);
        B50.setText("0");
    }

    public void B54CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B54Yes, B54No);
        isVisible(B55Text, B55, B54Yes.isSelected());
        InputData.setB54(b);
    }

    public void B54CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B54Yes, B54No);
        InputData.setB54(b);
        B55.setText("0");
    }

    public void B58CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B57Yes, B57No);
        isVisible(B59Text, B59, B57Yes.isSelected());
        InputData.setB57(b);
    }

    public void B58CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B57Yes, B57No);
        InputData.setB57(b);
        B59.setText("0");
    }

    public void B60CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B60Yes, B60No);
        isVisible(B61Text, B61, B60Yes.isSelected());
        InputData.setB60(b);
    }

    public void B60CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B60Yes, B60No);
        InputData.setB60(b);
        B61.setText("0");
    }

    public void B63CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B63Yes, B63No);
        isVisible(B64Text, B64, B63Yes.isSelected());
        isVisible(B65Text,B65,B63Yes.isSelected());
        InputData.setB63(b);
    }

    public void B63CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B63Yes, B63No);
        InputData.setB63(b);
        B64.setText("0");
        B65.setText("0");
    }

    // This is for the CheckBox logic
    public boolean CheckBoxYes(CheckBox yes, CheckBox no) {
        no.setDisable(yes.isSelected());
        return true;
    }

    public boolean CheckBoxNo(CheckBox yes, CheckBox no) {
        yes.setDisable(no.isSelected());
        return false;
    }


    public void isVisible(Text t, TextField f, boolean b) {
        t.setVisible(b);
        f.setVisible(b);
    }

    public void isVisible(Text t,CheckBox v, CheckBox b, boolean bool){
        t.setVisible(bool);
        v.setVisible(bool);
        b.setVisible(bool);
    }

    public double isPercentage(String s){
        if (s.contains("%")){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != 37){
                    stringBuilder.append(s.charAt(i));
                }
            }
            return Double.parseDouble(stringBuilder.toString()) * 0.01;
        }

        return Double.parseDouble(s) * 0.01;
    }

    public void Alert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Please fill in every single component");
        alert.show();
    }


    public void B52CheckYes(ActionEvent event) {
        boolean b = CheckBoxYes(B52Yes, B52No);
        InputData.setB52(b);
    }

    public void B52CheckNo(ActionEvent event) {
        boolean b = CheckBoxNo(B52Yes, B52No);
        InputData.setB52(b);
    }

    public void isBlank(DatePicker c) {
        //如果不填写，填写当前电脑日期还是？
    }

    //下拉菜单不选择适配数据库，还是？
    public void isBlank() {

    }

    public void isBlank(TextField c) {
        if (c.getText().isEmpty()) {
            c.setStyle("-fx-border-color: red;");
        }else {
            c.setStyle("-fx-border-color: rgb(230, 230, 230)");
        }
    }

    public void isBlank(CheckBox c, CheckBox d) {
        Parent parent = c.getParent();
        if (!(c.isSelected() | d.isSelected())) {
            parent.setStyle("-fx-border-color: red;");
        }else {
            parent.setStyle("-fx-border-color: rgb(230, 230, 230)");
        }
    }

    public void B49CheckB(ActionEvent actionEvent) {
        if (B49V.isSelected()){
            B49V.setSelected(false);
        }
    }

    public void B49CheckV(ActionEvent actionEvent) {
        if (B49B.isSelected()){
            B49B.setSelected(false);
        }
    }

    public void LightMode(ActionEvent actionEvent) {
        Scene scene = changeButton.getScene();
        
        scene.getStylesheets().removeAll("interface.css");

        scene.getStylesheets().add("interface.css");

        String[] ChineseSheet1={"日期" ,"公司名" ,"国家" ,"行业" ,"行业(全球)" ,"营业额" ,"营业利润"
                ,"利息费用" ,"股权账面价值" ,"债权账面价值" ,"是否有研发费用需要资本化?" ,"现金和适销证券"
                ,"交叉持股和其他非经营性资产" ,"少数股东权益" ,"流通股票数量" ,"当前股价" ,"有效税率" ,"边际税率"};
        String[] ChineseSheet2={"次年收入增长率", "次年营业利润率", "复合年收入增长率(2-5年)",
                "目标税前营业利润率", "几年实现经营利润率目标", "销售资本比率",};
        String[] ChineseSheet3={"是否存在未完成的员工期权？", "未完成的期权数量", "平均执行价格",
                "平均期限", "股价标准差",};
        String[] ChineseSheet4={"您想覆盖这个假设吗？",
                "输入第10年后的资本成本",
                "您想覆盖这个假设吗？",
                "输入第10年后您预期的资本回报率",
                "我将假设您的公司在第10年后的资本回报率等于其资本成本。我假设您今天拥有的任何竞争优势会随着时间的推移而消失。",
                "在稳定增长阶段，我将假设您的公司的资本成本类似于典型成熟公司的资本成本（无风险利率+4.5％）",
                "我将假设您的公司在可预见的未来没有失败的机会",
                "输入失败概率",
                "您想将失败的收益与什么联系起来？",
                "输入破产清算收益作为账面价值或公允价值的百分比",
                "您想覆盖这个假设吗？",
                "我将假设您的有效税率将调整为您终止年度的边际税率。如果您覆盖此假设，我将保持税率为您的有效税率。",
                "您想覆盖这个假设吗？"};
        String[] ChineseSheet5={"您想覆盖这个假设吗？",
                "输入您带入第1年的可抵税亏损（NOL）",
                "您想覆盖这个假设吗？",
                "输入第10年后的无风险利率",
                "我将假设今天的无风险利率将永久保持不变。如果您覆盖此假设，我将更改第10年后的无风险利率。",
                "我将假设您没有来自前几年的损失结转（NOL）进入估值。如果您的公司存在亏损，您可能需要覆盖此假设。",
                "我将假设永久增长率等于无风险利率。这既可以实现估值一致性，又可以避免“不可能”的增长率。",
                "输入永久增长率",
                "您想覆盖这个假设吗？",
                "我已假设现金没有被困住（在外国）并且没有额外的税收责任，现金是一项中性资产。",
                "您想覆盖这个假设吗？",
                "输入被困住的现金（如果是税）或整个余额（如果是不信任）",
                "被困住的现金所在国外市场的平均税率"};
        String[] ChineseSheet6={"请选择一个国家","请选择一个行业"};
        /*
        int i=0;
        for (Node node : Sheet1.getChildren()) {
            if (GridPane.getColumnIndex(node) == 1) {
                // Check if node is in second column
                if (node instanceof Text) {
                    // Check if node is a label or its subclass
                    System.out.println("233"+((Text) node).getText()+"233"+",");
                    ((Text) node).setText(ChineseSheet1[i]);
                    //System.out.println(ChineseSheet1[i]);
                    i++;
                    // Cast node to Labeled and set its text
                }
            }
        }
         */
        ChangeVersion(ChineseSheet1,Sheet1);
        ChangeVersion(ChineseSheet2,Sheet2);
        ChangeVersion(ChineseSheet3,Sheet3);
        ChangeVersion(ChineseSheet4,Sheet4);
        ChangeVersion(ChineseSheet5,Sheet5);
        ChangeVersion(ChineseSheet6,Sheet6);
    }

    public void DatabaseResult1(ActionEvent actionEvent) {
    }

    public void DatabaseResult2(ActionEvent actionEvent) {
    }

    public void ChangeVersion(String[] strings, GridPane gridPane){
        int i=0;
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == 1) {
                // Check if node is in second column
                if (node instanceof Text) {
                    if(!Objects.equals(((Text) node).getText(), "")){
                        // Check if node is a label or its subclass
                        System.out.println("\""+((Text) node).getText()+"\""+",");
                        ((Text) node).setText(strings[i]);
                        //System.out.println(ChineseSheet1[i]);
                        i++;
                        // Cast node to Labeled and set its text
                    }

                }
            }
        }
        System.out.println("");
    }

    public void Eng_Version(ActionEvent actionEvent) {
        String[] EnglishSheet1={"Date of valuation", "Company name", "Country", "Industry", "Industry (Global)",
                "Revenues", "EBIT", "Interest expense", "Book value of equity", "Book value of debt",
                "R&D expense to capitalize?", "Cash and Marketable Securities",
                "Crossing holdings", "Minority interests", "Number of shares outstanding",
                "Current stock price", "Effective tax rate", "Marginal tax rate",
        };
        String[] EnglishSheet2={"Revenue growth rate for next year",
                "Operating Margin for next year",
                "Compounded annual revenue growth rate - years 2-5",
                "Target pre-tax operating margin",
                "Year of convergence",
                "Sales to capital ratio",};
        String[] EnglishSheet3={"Do you have employee options outstanding?",
                "Number of options outstanding",
                "Average strike price",
                "Average maturity",
                "Standard deviation on stock price",};
        String[] EnglishSheet4={"Do you want to override this assumption",
                "Enter the cost of capital after year 10",
                "Do you want to override this assumption",
                "Enter the return on capital you expect after year 10",
                "I will assume that your firm will earn a return on capital equal to its cost of capital after year 10. I am assuming that whatever competitive advantages you have today will fade over time.",
                "In stable growth, I will assume that your firm will have a cost of capital similar to that of typical mature companies (riskfree rate + 4.5%)",
                "I will assume that your firm has no chance of failure over the foreseeable future",
                "Enter the probability of failure",
                "What do you want to tie your proceeds in failure to?",
                "Enter the distress proceeds as percentage of book or fair value",
                "Do you want to override this assumption",
                "I will assume that your effective tax rate will adjust to your marginal tax rate by your terminal year. If you override this assumption, I will leave the tax rate at your effective tax rate.",
                "Do you want to override this assumption",
        };
        String[] EnglishSheet5={"Do you want to override this assumption",
                "Enter the NOL that you are carrying over into year 1",
                "Do you want to override this assumption",
                "Enter the riskfree rate after year 10",
                "I will assume that today's risk free rate will prevail in perpetuity. If you override this assumption, I will change the riskfree rate after year 10.",
                "I will assume that you have no losses carried forward from prior years ( NOL) coming into the valuation. If you have a money losing company, you may want to override this.",
                "I will assume that the growth rate in perpetuity will be equal to the risk free rate. This allows for both valuation consistency and prevents \"impossible\" growth rates.",
                "Enter the growth rate in perpetuity",
                "Do you want to override this assumption?",
                "I have assumed that none of the cash is trapped (in foreign countries) and that there is no additional tax liability coming due and that cash is a neutral asset.",
                "Do you want to override this assumption",
                "Enter trapped cash (if taxes) or entire balance (if mistrust)",
                "Average tax rate of the foreign markets where the cash is trapped",
        };
        String[] EnglishSheet6={"Please choose a country",
                "Please choose an industry",};

        ChangeVersion(EnglishSheet1,Sheet1);
        ChangeVersion(EnglishSheet2,Sheet2);
        ChangeVersion(EnglishSheet3,Sheet3);
        ChangeVersion(EnglishSheet4,Sheet4);
        ChangeVersion(EnglishSheet5,Sheet5);
        ChangeVersion(EnglishSheet6,Sheet6);
        /*
        int i=0;
        for (Node node : Sheet1.getChildren()) {
            if (GridPane.getColumnIndex(node) == 1) {
                // Check if node is in second column
                if (node instanceof Text) {
                    // Check if node is a label or its subclass
                    System.out.println("233"+((Text) node).getText()+"233"+",");
                    ((Text) node).setText(EnglishSheet1[i]);
                    //System.out.println(ChineseSheet1[i]);
                    i++;
                    // Cast node to Labeled and set its text
                }
            }
        }
         */

    }
}
