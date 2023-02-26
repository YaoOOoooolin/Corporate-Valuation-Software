package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A9FCFF {

    public ArrayList<Double> fcffList = new ArrayList<>();


    public void setFcffList(A7EBIT1t ebit1t, A8Reinvestment reinvestment) {
        fcffList.add((double) 0);
        for (int i = 1; i <= 11; i++) {
            BigDecimal getEBIT1tListi=new BigDecimal(Double.toString(ebit1t.getEBIT1tList().get(i)));
            BigDecimal getReinvestmentListi=new BigDecimal((Double.toString(reinvestment.getReinvestmentList().get(i))));
            BigDecimal ans=getEBIT1tListi.subtract(getReinvestmentListi);


            double temp= ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double temp = ebit1t.getEBIT1tList().get(i) - reinvestment.getReinvestmentList().get(i);
            fcffList.add(temp);
        }
    }

    public ArrayList<Double> getFcffList() {
        return fcffList;
    }

    public double getTerminalFcff() {
        return fcffList.get(11);
    }


}
