package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A2RevenueGrowthRate {

    public ArrayList<Double> revenueGrowthRateList = new ArrayList<>();
    public double terminalRevenue;

    public void setTerminalRevenue(boolean inputA60, double inputA61, boolean inputA57, double inputA58, double inputA30) {
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

    public double getTerminalRevenue() {
        return terminalRevenue;
    }

    public void setRevenueGrowthRateList(double inputA23, double inputA25, double terminalRevenue) {
        revenueGrowthRateList.add((double) 0);
        revenueGrowthRateList.add(inputA23);
        for (int i = 1; i <= 4; i++) {
            revenueGrowthRateList.add(inputA25);
        }

        for (int i = 5; i < 10; i++) {


            BigDecimal big_get2 = new BigDecimal(Double.toString(revenueGrowthRateList.get(2)));
            BigDecimal big_terminalvalue=new BigDecimal(Double.toString(terminalRevenue));
            BigDecimal big_int5=new BigDecimal("5");
            BigDecimal big_temp=new BigDecimal(Double.toString(i - 4));

            BigDecimal ans1=big_get2.subtract(big_terminalvalue);
            BigDecimal ans2=ans1.divide(big_int5,20, RoundingMode.HALF_UP);
            BigDecimal ans3=ans2.multiply(big_temp);
            BigDecimal ans4=big_get2.subtract(ans3);


            double ans=ans4.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double ans = revenueGrowthRateList.get(2) - (revenueGrowthRateList.get(2) - terminalRevenue) / 5 * (i - 4);


            revenueGrowthRateList.add(ans);
        }
        revenueGrowthRateList.add(terminalRevenue);
    }

    public ArrayList<Double> getRevenueGrowthRateList() {
        return revenueGrowthRateList;
    }

    public double getTerminalRevenueGrowthRate() {
        return revenueGrowthRateList.get(11);
    }
}




