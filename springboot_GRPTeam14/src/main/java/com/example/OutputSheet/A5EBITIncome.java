package com.example.OutputSheet;

import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

import java.util.ArrayList;

public class A5EBITIncome {

    ArrayList<Float> ebitIncomeList = new ArrayList<>();
    public float operatingIncomeGrew=0;


    public void setEBITIncomeList(A3Revenues revenues, A4EBITMargin ebitMargin) {
        ebitIncomeList.add(ebitMargin.getBaseIncome());

        for (int i = 1; i <= 11; i++) {
            float temp = revenues.getRevenuesList().get(i) * ebitMargin.getEBITMarginList().get(i);
            ebitIncomeList.add(temp);
        }

        operatingIncomeGrew=ebitIncomeList.get(11) - ebitIncomeList.get(0);
        ebitIncomeList.add(operatingIncomeGrew);
    }

    public ArrayList<Float> getEBITIncomeList() {
        return ebitIncomeList;
    }
    public float getOperatingIncomeGrew(){
        return operatingIncomeGrew;
    }

}

