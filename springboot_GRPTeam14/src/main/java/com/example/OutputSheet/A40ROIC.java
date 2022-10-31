package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;

import java.util.ArrayList;
//todo
public class A40ROIC {

    public ArrayList<Float> roicList=new ArrayList<>();


    public float terminaLROIC;

    public void setTerminaLROIC(boolean inputB44,float inputB45,A12CostOfCapital costOfCapital) {
        if (inputB44){
            terminaLROIC=inputB45;
        }else {
            terminaLROIC=costOfCapital.getTerminalostOfCapital();
        }
    }

    public float getTerminaLROIC() {
        return terminaLROIC;
    }


}

class TestA40ROIC{
    public static void main(String[] args) {
        InputData data=new InputData();
        CountryEquityRiskPremiums cerp=new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital=new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(),data.getB42(),data.isB57(), data.getB58(), cerp.getB1(), data.getB30());

        A40ROIC roic=new A40ROIC();
        roic.setTerminaLROIC(data.isB44(),data.getB45(),costOfCapital);
        System.out.println(roic.getTerminaLROIC());



    }
}