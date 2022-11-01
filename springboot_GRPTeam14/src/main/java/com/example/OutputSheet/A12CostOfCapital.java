package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;

import java.util.ArrayList;


//todo
public class A12CostOfCapital {
    public ArrayList<Float> costOfCapitalList = new ArrayList<>();

    public float getTerminalcostOfCapital() {
        return terminalcostOfCapital;
    }

    public float terminalcostOfCapital;


    public void setTerminalcostOfCapital(boolean inputB41,float inputB42,boolean inputB57, float inputB58,float countryEquityRiskPremiumsB1,float inputB30) {
        if (inputB41){
            terminalcostOfCapital=inputB42;
        }
        else{
            if(inputB57){
                terminalcostOfCapital= (float) (inputB58+0.8*(countryEquityRiskPremiumsB1));
            }
            else {
                terminalcostOfCapital=(float) (inputB30+0.8*(countryEquityRiskPremiumsB1));
            }
        }
    }


    public void setCostOfCapitalList(float B31) {
        costOfCapitalList.add((float) 0);

        for (int i = 1; i <=5 ; i++) {
        costOfCapitalList.add(B31);
        }
        for (int i = 6; i <=10 ; i++) {
              float temp=costOfCapitalList.get(i-1)-(( costOfCapitalList.get(5) -terminalcostOfCapital  )/5);
              costOfCapitalList.add(temp);
        }
        costOfCapitalList.add(terminalcostOfCapital);

    }

    public ArrayList<Float> getCostOfCapitalList() {
        return costOfCapitalList;
    }



}


class TestA12CostOfCapital{
    public static void main(String[] args) {
        InputData data=new InputData();
        CountryEquityRiskPremiums cerp=new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital=new A12CostOfCapital();
        costOfCapital.setTerminalcostOfCapital(data.isB41(),data.getB42(),data.isB57(), data.getB58(), cerp.getB1(), data.getB30());
        costOfCapital.setCostOfCapitalList(data.getB31());
        System.out.println(costOfCapital.getCostOfCapitalList().toString());

    }
}
