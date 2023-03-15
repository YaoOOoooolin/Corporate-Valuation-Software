package com.back.example.OutputSheet;

import java.util.ArrayList;

public class A12CostOfCapital2 {

    public ArrayList<Double> getCostOfCapitalList() {
        return costOfCapitalList;
    }

    public ArrayList<Double> costOfCapitalList = new ArrayList<>();

        public void setcostOfCapitalList(ArrayList<Double> inputA2RevenueGrowthRateList){
            for (int i = 0; i < inputA2RevenueGrowthRateList.size()-1.; i++) {
                costOfCapitalList.add(inputA2RevenueGrowthRateList.get(i));
            }
        }


}
