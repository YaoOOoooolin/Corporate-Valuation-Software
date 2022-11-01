package com.example.OutputSheet;

import com.StaticData.InputData;

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

class TestA38SalesToCapitalRatio{
    public static void main(String[] args) {

        InputData inputData=new InputData();
        A38SalesToCapitalRatio salesToCapitalRatio=new A38SalesToCapitalRatio();
        salesToCapitalRatio.setSalesToCapitalRatioList(inputData.getB28());
        System.out.println(salesToCapitalRatio.getSalesToCapitalRatioList().toString());


    }
}
