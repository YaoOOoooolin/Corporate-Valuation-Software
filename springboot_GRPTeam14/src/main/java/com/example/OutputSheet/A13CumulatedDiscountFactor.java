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
