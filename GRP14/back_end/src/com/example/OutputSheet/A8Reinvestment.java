package com.example.OutputSheet;

import java.util.ArrayList;

public class A8Reinvestment {
    public ArrayList<Float> reinvestmentList = new ArrayList<>();
    float sum=0;

    public void setReinvestmentList(A3Revenues revenues,float inputB28,A2RevenueGrowthRate revenueGrowthRate,A40ROIC roic,A7EBIT1t ebit1t) {
        reinvestmentList.add((float) 0);
        for (int i = 1; i <= 10; i++) {
            float temp = (revenues.getRevenuesList().get(i)-revenues.getRevenuesList().get(i-1))/inputB28;
            reinvestmentList.add(temp);
        }
       if(revenueGrowthRate.getTerminalRevenueGrowthRate()>0){
           float temp=(revenueGrowthRate.getTerminalRevenueGrowthRate()/roic.getTerminaLROIC())*ebit1t.getTerminalEBIT1t();
            reinvestmentList.add(temp);
       }

        for (int i = 1; i <=11 ; i++) {
            sum+=reinvestmentList.get(i);
        }
        reinvestmentList.add(sum);
    }

    public ArrayList<Float> getReinvestmentList (){
        return reinvestmentList;
    }

    public float getTerminalreinvestment(){
        return reinvestmentList.get(11);
    }

    public float getSum() {
        return sum;
    }
}
