package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;

import java.util.ArrayList;

public class A13CumulatedDiscountFactor {
    public ArrayList<Float> cumulatedDFList=new ArrayList<>();


    public void setCumulatedDFListList(A12CostOfCapital costOfCapital) {
        cumulatedDFList.add((float) 0);
        cumulatedDFList.add( 1/(1+costOfCapital.getCostOfCapitalList().get(1))  );
        for (int i = 2; i <=10 ; i++) {
            float temp=   cumulatedDFList.get(i-1)*( 1/(1+costOfCapital.getCostOfCapitalList().get(i)));
            cumulatedDFList.add(temp);
        }

    }

    public ArrayList<Float> getCumulatedDFList() {
        return cumulatedDFList;
    }

}

class TestA13CumulatedDiscountFactor {
    public static void main(String[] args) {
        InputData data=new InputData();
        CountryEquityRiskPremiums cerp=new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital=new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(),data.getB42(),data.isB57(), data.getB58(), cerp.getB1(), data.getB30());
        costOfCapital.setCostOfCapitalList(data.getB31());
        A13CumulatedDiscountFactor cumulatedDF=new A13CumulatedDiscountFactor();
        cumulatedDF.setCumulatedDFListList(costOfCapital);
        System.out.println(cumulatedDF.getCumulatedDFList().toString());

    }


}