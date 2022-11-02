package com.example.OutputSheet;

import com.StaticData.InputData;

import java.util.ArrayList;

public class A6TaxRate {
    public ArrayList<Float> taxRateList = new ArrayList<>();

    public void setTaxRateList(float inputB20) {
        for (int i = 0; i <=11; i++) {
        taxRateList.add(inputB20);
        }
    }

    public ArrayList<Float> getTaxRateList() {
        return taxRateList;
    }

    public float getTerminalTaxRate() {
        return taxRateList.get(11);
    }
}

