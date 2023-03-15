package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A3Revenues {

    public ArrayList<Double> revenuesList = new ArrayList<>();

    public void setA3RevenuesList(double A8, A2RevenueGrowthRate revenueGrowthRate,int yearOfList) {
        revenuesList.add(A8);
        for (int i = 1; i <= yearOfList+1; i++) {


            double temp1=revenueGrowthRate.getRevenueGrowthRateList().get(i)+1;
            BigDecimal ans1= new BigDecimal(Double.toString(temp1));
            BigDecimal big_getrevenue=new BigDecimal(Double.toString(revenuesList.get(i-1)));

            BigDecimal ans2=ans1.multiply(big_getrevenue);

            double ans = ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double ans = (1 + revenueGrowthRate.getRevenueGrowthRateList().get(i)) * (revenuesList.get(i - 1));
            revenuesList.add(ans);
        }
    }

    public ArrayList<Double> getRevenuesList() {
        return revenuesList;
    }

    public double getTerminalRevenues() {
        return revenuesList.get(revenuesList.size()-1);
    }


}
