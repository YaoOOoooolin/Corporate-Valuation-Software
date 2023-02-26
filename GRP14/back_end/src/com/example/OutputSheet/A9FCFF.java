package com.example.OutputSheet;

import java.util.ArrayList;

public class A9FCFF {

    public ArrayList<Float> fcffList=new ArrayList<>();


    public void setFcffList(A7EBIT1t ebit1t, A8Reinvestment reinvestment) {
        fcffList.add((float) 0);
        for (int i = 1; i <=11; i++) {
        float temp= ebit1t.getEBIT1tList().get(i)-reinvestment.getReinvestmentList().get(i);
        fcffList.add(temp);
        }
    }

    public ArrayList<Float> getFcffList() {
        return fcffList;
    }

    public float getTerminalFcff(){
        return fcffList.get(11);
    }


}
