package com.example.OutputSheet;

import java.util.ArrayList;

public class A38SalesToCapitalRatio {

    public ArrayList <Double> salesToCapitalRatioList=new ArrayList<>();

    public void setSalesToCapitalRatioList(double inputB28) {
        salesToCapitalRatioList.add((double) 0);
        for (int i = 1; i <=10 ; i++) {
            salesToCapitalRatioList.add(inputB28);
        }
    }


    public ArrayList<Double> getSalesToCapitalRatioList() {
        return salesToCapitalRatioList;
    }
}
