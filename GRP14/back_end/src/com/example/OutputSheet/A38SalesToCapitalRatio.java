package com.example.OutputSheet;

import java.util.ArrayList;

public class A38SalesToCapitalRatio {

    public ArrayList <Float> salesToCapitalRatioList=new ArrayList<>();

    public void setSalesToCapitalRatioList(float inputB28) {
        salesToCapitalRatioList.add((float) 0);
        for (int i = 1; i <=10 ; i++) {
            salesToCapitalRatioList.add(inputB28);
        }
    }


    public ArrayList<Float> getSalesToCapitalRatioList() {
        return salesToCapitalRatioList;
    }
}
