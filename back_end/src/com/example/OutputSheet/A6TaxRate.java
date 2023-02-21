package com.example.OutputSheet;

import java.util.ArrayList;

public class A6TaxRate {
    public ArrayList<Double> taxRateList = new ArrayList<>();

    public void setTaxRateList(double inputB20) {
        for (int i = 0; i <=11; i++) {
        taxRateList.add(inputB20);
        }
    }

    public ArrayList<Double> getTaxRateList() {
        return taxRateList;
    }

    public Double getTerminalTaxRate() {
        return taxRateList.get(11);
    }
}

