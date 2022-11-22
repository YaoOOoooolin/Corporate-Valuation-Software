package com.example.OutputSheet;

import java.util.ArrayList;

public class A3Revenues {

    public ArrayList<Float> revenuesList = new ArrayList<>();

    public void setA3RevenuesList(float A8, A2RevenueGrowthRate revenueGrowthRate) {
        revenuesList.add(A8);
        for (int i = 1; i <= 11; i++) {
            float temp = (1 + revenueGrowthRate.getRevenueGrowthRateList().get(i)) * (revenuesList.get(i - 1));
            revenuesList.add(temp);
        }
    }

    public ArrayList<Float> getRevenuesList() {
        return revenuesList;
    }

    public float getTerminalRevenues() {
        return revenuesList.get(11);
    }


}
