package com.example.OutputSheet;

import com.StaticData.InputData;

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

class TestA3Revenues {

    public static void main(String[] args) {
        InputData data = new InputData();
        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);
        ArrayList<Float> A3List = revenues.getRevenuesList();
        System.out.println(A3List.toString());
        System.out.println(revenues.getTerminalRevenues());


    }

}
