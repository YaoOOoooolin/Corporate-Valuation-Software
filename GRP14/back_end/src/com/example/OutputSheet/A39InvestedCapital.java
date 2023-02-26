package com.example.OutputSheet;

import java.util.ArrayList;

public class A39InvestedCapital {

    public ArrayList<Float> investedCapitalList=new ArrayList<>();


    public void setInvestedCapitalList(Boolean inputB14,Boolean inputB13,float inputB12,float inputB15,float inputB11,float olcF33, float rdcD35,A8Reinvestment reinvestment) {
            float temp;

            if(inputB14){
                if (inputB13){
                    temp=inputB11+inputB12-inputB15+olcF33+rdcD35;
                }else {
                    temp=inputB11+inputB12-inputB15+olcF33;
                }
            }
            else {
                if (inputB13){
                    temp=inputB11+inputB12-inputB15+rdcD35;
                }
                else {
                    temp=inputB11+inputB12-inputB15;
                }
            }

            investedCapitalList.add(temp);

        for (int i = 1; i < 10; i++) {
            float temp_1=investedCapitalList.get(i-1)+reinvestment.getReinvestmentList().get(i);
            investedCapitalList.add(temp_1);
        }
    }


    public ArrayList<Float> getInvestedCapitalList() {
        return investedCapitalList;
    }
}

