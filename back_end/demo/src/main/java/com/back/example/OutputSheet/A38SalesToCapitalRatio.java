package com.back.example.OutputSheet;

import java.util.ArrayList;

public class A38SalesToCapitalRatio {

    public ArrayList <Double> salesToCapitalRatioList=new ArrayList<>();

    public void setSalesToCapitalRatioList(double inputB28,int yearOfList) {
        salesToCapitalRatioList.add((double) 0);
        for (int i = 1; i <=yearOfList ; i++) {
            salesToCapitalRatioList.add(inputB28);
        }
    }


    public ArrayList<Double> getSalesToCapitalRatioList() {
        return salesToCapitalRatioList;
    }
}
