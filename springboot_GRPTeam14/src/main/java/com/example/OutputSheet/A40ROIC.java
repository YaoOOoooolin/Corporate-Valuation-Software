package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

import java.util.ArrayList;

public class A40ROIC {

    public ArrayList<Float> roicList=new ArrayList<>();


    public float terminaLROIC;

    public void setTerminaLROIC(boolean inputB44,float inputB45,A12CostOfCapital costOfCapital) {
        if (inputB44) {
            terminaLROIC = inputB45;
        } else {
            terminaLROIC = costOfCapital.getTerminalostOfCapital();
        }
    }

    public void setRoicList(A7EBIT1t ebit1t, A39InvestedCapital investedCapital){
        for (int i = 0; i <=9; i++) {
            float temp=ebit1t.getEBIT1tList().get(i)/investedCapital.investedCapitalList.get(i);
            roicList.add(temp);
        }
        roicList.add(terminaLROIC);

    }



    public ArrayList<Float> getRoicList(){
        return roicList;
    }
    public float getTerminaLROIC() {
        return terminaLROIC;
    }





}

