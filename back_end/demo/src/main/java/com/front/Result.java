package com.front;

import com.back.example.OutPutMethod;
import com.back.example.TestOutputSheet;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Result {
        public Text F14;
        public Text B11;
        public Text F13;
        public Text F12;
        public Text F11;
        public Text F10;
        public Text B14;
        public Text B13;
        public Text B12;
        public Text G14;
        public Text G9;
        public Text G12;
        public Text G11;
        public Text G10;
        public Text B10;
        public Text F9;
        public Text C14;
        public Text D11;
        public Text C11;
        public Text D10;
        public Text C10;
        public Text D9; //
        public Text C9; //
        public Text D13;
        public Text D14;
        public Text G13;
        public Text C23;
        public Text C22;
        public Text C21;
        public Text C20;
        public Text C19;
        public Text C18;
        public Text C17;
        public Text B27;
        public Text B26;
        public Text B25;
        public Text B24;
        public Text B23;
        public Text B22;
        public Text B21;
        public Text B20;
        public Text B19;
        public Text B18;
        public Text B17;
        public Text D22;
        public Text D21;
        public Text D20;
        public Text D19;
        public Text D18;
        public Text D17;
        public Text C27;
        public Text C26;
        public Text C25;
        public Text C24;
        public Text D27;
        public Text D26;
        public Text D25;
        public Text D24;
        public Text D23;
        public Text E17;
        public Text E18;
        public Text E19;
        public Text E20;
        public Text E21;
        public Text E26;
        public Text E25;
        public Text E24;
        public Text E23;
        public Text F26;
        public Text F22;
        public Text E22;
        public Text F23;
        public Text F24;
        public Text F25;
        public Text F27;
        public Text F17;
        public Text F18;
        public Text F19;
        public Text F20;
        public Text F21;
        public Text E27;
        public Text G17;
        public Text G18;
        public Text G19;
        public Text G20;
        public Text G21;
        public Text G22;
        public Text G23;
        public Text G24;
        public Text G25;
        public Text G26;
        public Text G27;
        public Text D35;
        public Text D34;
        public Text D33;
        public Text D32;
        public Text D31;
        public Text D30;
        public Text D29;
        public Text D39;
        public Text D38;
        public Text D37;
        public Text D36;
        public Text G33;
        public Text G39;
        public Text Story_id;
        public Text CompanyName_id;
        public Text B9;  //
        public Text D12;

        /*所有的参数按照initialize来填*/
        @FXML
        public void initialize() {
                double outputB9 = OutPutMethod.outputB9();
                B9.setText(String.valueOf(outputB9));

                double outputC9 = OutPutMethod.outputC9();
                C9.setText(String.valueOf(outputC9));

                double outputD9 = OutPutMethod.outputD9();
                D9.setText(String.valueOf(outputD9));

                double outputF9 = OutPutMethod.outputF9();
                F9.setText(String.valueOf(outputF9));


                double outputB10 = OutPutMethod.outputB10();
                B10.setText(String.valueOf(outputB10));

                double outputC10 = OutPutMethod.outputC10();
                C10.setText(String.valueOf(outputC10));

                double outputD10 = OutPutMethod.outputD10();
                D10.setText(String.valueOf(outputD10));

                double outputF10 = OutPutMethod.outputF10();
                F10.setText(String.valueOf(outputF10));


                double outputB11 = OutPutMethod.outputB11();
                B11.setText(String.valueOf(outputB11));

                double outputC11 = OutPutMethod.outputC11();
                C11.setText(String.valueOf(outputC11));

                double outputD11 = OutPutMethod.outputD11();
                D11.setText(String.valueOf(outputD11));

                double outputF11 = OutPutMethod.outputF11();
                F11.setText(String.valueOf(outputF11));


                double outputD12 = OutPutMethod.outputD12();
                D12.setText(String.valueOf(outputD12));

                double outputF12 = OutPutMethod.outputF12();
                F12.setText(String.valueOf(outputF12));


                double outputB13 = OutPutMethod.outputB13();
                B13.setText(String.valueOf(outputB13));

                double outputD13 = OutPutMethod.outputD13();
                D13.setText(String.valueOf(outputD13));

                double outputF13 = OutPutMethod.outputF13();
                F13.setText(String.valueOf(outputF13));


                double outputC14 = OutPutMethod.outputC14();
                C14.setText(String.valueOf(outputC14));

                double outputD14 = OutPutMethod.outputD14();
                D14.setText(String.valueOf(outputD14));

                double outputF14 = OutPutMethod.outputF14();
                F14.setText(String.valueOf(outputF14));


                double outputD29 = OutPutMethod.outputD29();
                D29.setText(String.valueOf(outputD29));


                double outputD30 = OutPutMethod.outputD30();
                D30.setText(String.valueOf(outputD30));

                double outputD31 = OutPutMethod.outputD31();
                D31.setText(String.valueOf(outputD31));


                double outputD32 = OutPutMethod.outputD32();
                D32.setText(String.valueOf(outputD32));


                double outputD33 =  Double.parseDouble(D32.getText()) - OutPutMethod.outputB24();
                D33.setText(String.valueOf(outputD33));

                double outputD34 = OutPutMethod.outputD34();
                D34.setText(String.valueOf(outputD34));


                double outputD35 = OutPutMethod.outputD35();
                D35.setText(String.valueOf(outputD35));

                double outputD36 = Double.parseDouble(D32.getText()) - Double.parseDouble(D33.getText()) - Double.parseDouble(D34.getText()) + Double.parseDouble(D35.getText());
                D36.setText(String.valueOf(outputD36));

                double outputD37 = OutPutMethod.outputD37();
                D37.setText(String.valueOf(outputD37));

                double outputD38 = OutPutMethod.outputD38();
                D38.setText(String.valueOf(outputD38));

                double outputD39 = (Double.parseDouble(D36.getText()) - Double.parseDouble(D37.getText())) / Double.parseDouble(D38.getText());
                BigDecimal bd = new BigDecimal(outputD39);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                D39.setText(String.valueOf(bd));


                double outputG33 = OutPutMethod.outputG33();
                G33.setText(String.valueOf(outputG33));

                double outputG39 = OutPutMethod.outputD39();
                G39.setText(String.valueOf(outputG39));

                ArrayList<Double> outputRevenuesList=OutPutMethod.outputRevenuesList();
                B17.setText(String.valueOf(outputRevenuesList.get(1)));
                B18.setText(String.valueOf(outputRevenuesList.get(2)));
                B19.setText(String.valueOf(outputRevenuesList.get(3)));
                B20.setText(String.valueOf(outputRevenuesList.get(4)));
                B21.setText(String.valueOf(outputRevenuesList.get(5)));
                B22.setText(String.valueOf(outputRevenuesList.get(6)));
                B23.setText(String.valueOf(outputRevenuesList.get(7)));
                B24.setText(String.valueOf(outputRevenuesList.get(8)));
                B25.setText(String.valueOf(outputRevenuesList.get(9)));
                B26.setText(String.valueOf(outputRevenuesList.get(10)));
                B27.setText(String.valueOf(outputRevenuesList.get(11)));


                ArrayList<Double> outputebitMarginList=OutPutMethod.outputebitMarginList();
                C17.setText(String.valueOf(outputebitMarginList.get(1)));
                C18.setText(String.valueOf(outputebitMarginList.get(2)));
                C19.setText(String.valueOf(outputebitMarginList.get(3)));
                C20.setText(String.valueOf(outputebitMarginList.get(4)));
                C21.setText(String.valueOf(outputebitMarginList.get(5)));
                C22.setText(String.valueOf(outputebitMarginList.get(6)));
                C23.setText(String.valueOf(outputebitMarginList.get(7)));
                C24.setText(String.valueOf(outputebitMarginList.get(8)));
                C25.setText(String.valueOf(outputebitMarginList.get(9)));
                C26.setText(String.valueOf(outputebitMarginList.get(10)));
                C27.setText(String.valueOf(outputebitMarginList.get(11)));


                ArrayList<Double> outputEBIT1_tList=OutPutMethod.outputEBIT1_tList();
                E17.setText(String.valueOf(outputEBIT1_tList.get(1)));
                E18.setText(String.valueOf(outputEBIT1_tList.get(2)));
                E19.setText(String.valueOf(outputEBIT1_tList.get(3)));
                E20.setText(String.valueOf(outputEBIT1_tList.get(4)));
                E21.setText(String.valueOf(outputEBIT1_tList.get(5)));
                E22.setText(String.valueOf(outputEBIT1_tList.get(6)));
                E23.setText(String.valueOf(outputEBIT1_tList.get(7)));
                E24.setText(String.valueOf(outputEBIT1_tList.get(8)));
                E25.setText(String.valueOf(outputEBIT1_tList.get(9)));
                E26.setText(String.valueOf(outputEBIT1_tList.get(10)));
                E27.setText(String.valueOf(outputEBIT1_tList.get(11)));


                ArrayList<Double> outputreinvestmentList=OutPutMethod.outputReinvestmentList();
                F17.setText(String.valueOf(outputreinvestmentList.get(1)));
                F18.setText(String.valueOf(outputreinvestmentList.get(2)));
                F19.setText(String.valueOf(outputreinvestmentList.get(3)));
                F20.setText(String.valueOf(outputreinvestmentList.get(4)));
                F21.setText(String.valueOf(outputreinvestmentList.get(5)));
                F22.setText(String.valueOf(outputreinvestmentList.get(6)));
                F23.setText(String.valueOf(outputreinvestmentList.get(7)));
                F24.setText(String.valueOf(outputreinvestmentList.get(8)));
                F25.setText(String.valueOf(outputreinvestmentList.get(9)));
                F26.setText(String.valueOf(outputreinvestmentList.get(10)));
                F27.setText(String.valueOf(outputreinvestmentList.get(12)));


                int dTemp = (int) (Double.parseDouble(B17.getText()) * Double.parseDouble(C17.getText()));
                String sdTemp = isNegative(dTemp);
                D17.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B18.getText()) * Double.parseDouble(C18.getText()));
                sdTemp = isNegative(dTemp);
                D18.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B19.getText()) * Double.parseDouble(C19.getText()));
                sdTemp = isNegative(dTemp);
                D19.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B20.getText()) * Double.parseDouble(C20.getText()));
                sdTemp = isNegative(dTemp);
                D20.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B21.getText()) * Double.parseDouble(C21.getText()));
                sdTemp = isNegative(dTemp);
                D21.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B22.getText()) * Double.parseDouble(C22.getText()));
                sdTemp = isNegative(dTemp);
                D22.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B23.getText()) * Double.parseDouble(C23.getText()));
                sdTemp = isNegative(dTemp);
                D23.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B24.getText()) * Double.parseDouble(C24.getText()));
                sdTemp = isNegative(dTemp);
                D24.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B25.getText()) * Double.parseDouble(C25.getText()));
                sdTemp = isNegative(dTemp);
                D25.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B26.getText()) * Double.parseDouble(C26.getText()));
                sdTemp = isNegative(dTemp);
                D26.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(B27.getText()) * Double.parseDouble(C27.getText()));
                sdTemp = isNegative(dTemp);
                D27.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E17.getText()) - Double.parseDouble(F17.getText()));
                sdTemp = isNegative(dTemp);
                G17.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E18.getText()) - Double.parseDouble(F18.getText()));
                sdTemp = isNegative(dTemp);
                G18.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E19.getText()) - Double.parseDouble(F19.getText()));
                sdTemp = isNegative(dTemp);
                G19.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E20.getText()) - Double.parseDouble(F20.getText()));
                sdTemp = isNegative(dTemp);
                G20.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E21.getText()) - Double.parseDouble(F21.getText()));
                sdTemp = isNegative(dTemp);
                G21.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E22.getText()) - Double.parseDouble(F22.getText()));
                sdTemp = isNegative(dTemp);
                G22.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E23.getText()) - Double.parseDouble(F23.getText()));
                sdTemp = isNegative(dTemp);
                G23.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E24.getText()) - Double.parseDouble(F24.getText()));
                sdTemp = isNegative(dTemp);
                G24.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E25.getText()) - Double.parseDouble(F25.getText()));
                sdTemp = isNegative(dTemp);
                G25.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E26.getText()) - Double.parseDouble(F26.getText()));
                sdTemp = isNegative(dTemp);
                G26.setText(sdTemp);

                dTemp = (int) (Double.parseDouble(E27.getText()) - Double.parseDouble(F27.getText()));
                sdTemp = isNegative(dTemp);
                G27.setText(sdTemp);

        }

        private String  isNegative(int value) {
                String result = "";
                if (value < 0){
                        value *= -1;
                        result = "(" + value +")";
                }else{
                        result = value + "";
                }
                return result;
        }


}