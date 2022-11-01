package com.example.OutputSheet;

import com.StaticData.InputData;

import java.util.ArrayList;

public class A2RevenueGrowthRate {

    public ArrayList<Float> revenueGrowthRateList = new ArrayList<>();
    public float terminalRevenue;

    public void setTerminalRevenue(boolean inputA60, float inputA61, boolean inputA57, float inputA58, float inputA30) {
        if (inputA60) {
            terminalRevenue = inputA61;
        } else {
            if (inputA57) {
                terminalRevenue = inputA58;
            } else {
                terminalRevenue = inputA30;
            }
        }
    }

    public float getTerminalRevenue() {
        return terminalRevenue;
    }

    public void setRevenueGrowthRateList(float inputA23, float inputA25, float terminalRevenue) {
        revenueGrowthRateList.add((float) 0);
        revenueGrowthRateList.add(inputA23);
        for (int i = 1; i <= 4; i++) {
            revenueGrowthRateList.add(inputA25);
        }

        for (int i = 5; i < 10; i++) {
            float temp = (revenueGrowthRateList.get(2) - (revenueGrowthRateList.get(2) - terminalRevenue) / 5 * (i - 4));
            revenueGrowthRateList.add(temp);
        }
        revenueGrowthRateList.add(terminalRevenue);
    }

    public ArrayList<Float> getRevenueGrowthRateList() {
        return revenueGrowthRateList;
    }

    public float getTerminalRevenueGrowthRate() {
        return revenueGrowthRateList.get(11);
    }
}


class TestA2RevenueGrowthRate {
    public static void main(String[] args) {
        InputData data = new InputData();

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();

        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());

        ArrayList<Float> A2List = revenueGrowthRate.getRevenueGrowthRateList();

        System.out.println(A2List.toString());

        System.out.println(revenueGrowthRate.getTerminalRevenueGrowthRate());


    }



}


