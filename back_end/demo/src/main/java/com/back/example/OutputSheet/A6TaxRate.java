package com.back.example.OutputSheet;

import java.util.ArrayList;

public class A6TaxRate {
    public ArrayList<Double> taxRateList = new ArrayList<>();

    public void setTaxRateList(double inputB20,int yearOfList) {
        for (int i = 0; i <=1+yearOfList; i++) {
        taxRateList.add(inputB20);
        }
    }

    public ArrayList<Double> getTaxRateList() {
        return taxRateList;
    }

    public Double getTerminalTaxRate() {
        return taxRateList.get(taxRateList.size()-1);
    }
}

