package com.example.OutputSheet;

import java.util.ArrayList;


//todo
public class A12CostOfCapital {
    public ArrayList<Float> costOfCapitalList=new ArrayList<>();

    public float getTerminalostOfCapital() {
        return terminalostOfCapital;
    }

    public float terminalostOfCapital;


    public void setTerminalostOfCapital(boolean inputB41,float inputB42,boolean inputB57, float inputB58,float countryEquityRiskPremiumsB1,float inputB30) {
        if (inputB41){
            terminalostOfCapital=inputB42;
        }
        else{
            if(inputB57){
                terminalostOfCapital= (float) (inputB58+0.8*(countryEquityRiskPremiumsB1));
            }
            else {
                terminalostOfCapital=(float) (inputB30+0.8*(countryEquityRiskPremiumsB1));
            }
        }
    }


    public void setCostOfCapitalList(float B31) {
        costOfCapitalList.add((float) 0);

        for (int i = 1; i <=5 ; i++) {
        costOfCapitalList.add(B31);
        }
        for (int i = 6; i <=10 ; i++) {
              float temp=costOfCapitalList.get(i-1)-(( costOfCapitalList.get(5) -terminalostOfCapital  )/5);
              costOfCapitalList.add(temp);
        }
        costOfCapitalList.add(terminalostOfCapital);

    }

    public ArrayList<Float> getCostOfCapitalList() {
        return costOfCapitalList;
    }



}

