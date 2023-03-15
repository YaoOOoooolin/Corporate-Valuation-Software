package com.back.example.OutputSheet;

import com.back.StaticData.InputData;

import java.util.ArrayList;

public class A2RevenueGrowthRate2 {
    public ArrayList<Double> getRevenueGrowthRateList() {
        return revenueGrowthRateList;
    }

    public ArrayList<Double> revenueGrowthRateList = new ArrayList<>();

    public void setRevenueGrowthRateList(ArrayList<Double> inputA2RevenueGrowthRateList){
        for (int i = 0; i < inputA2RevenueGrowthRateList.size()-1.; i++) {
            revenueGrowthRateList.add(inputA2RevenueGrowthRateList.get(i));
        }
    }
}
