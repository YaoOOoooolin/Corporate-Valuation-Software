package com.example.OutputSheet;

import com.example.StaticData.InputData;

import java.util.ArrayList;

public class A6TaxRate {
    public ArrayList<Float> taxRateList = new ArrayList<>();

    public void setTaxRateList(float B20) {
        for (int i = 0; i <=11; i++) {
        taxRateList.add(B20);
        }
    }

    public ArrayList<Float> getTaxRateList() {
        return taxRateList;
    }

    public float getTerminalTaxRate() {
        return taxRateList.get(11);
    }
}


class TestA6TaxRate{
    public static void main(String[] args) {
        InputData date=new InputData();


        A6TaxRate taxRate=new A6TaxRate();
        taxRate.setTaxRateList(date.getB20());
        System.out.println(taxRate.getTaxRateList().toString());
    }
}
