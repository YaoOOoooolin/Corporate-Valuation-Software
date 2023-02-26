package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A5EBITIncome {

    ArrayList<Double> ebitIncomeList = new ArrayList<>();
    public double operatingIncomeGrew = 0;


    public void setEBITIncomeList(A3Revenues revenues, A4EBITMargin ebitMargin) {
        ebitIncomeList.add(ebitMargin.getBaseIncome());

        for (int i = 1; i <= 11; i++) {
            BigDecimal big_get_reven = new BigDecimal(Double.toString(revenues.getRevenuesList().get(i)));
            BigDecimal big_get_ebitMargin = new BigDecimal(Double.toString(ebitMargin.getEBITMarginList().get(i)));
            BigDecimal ans1 = big_get_reven.multiply(big_get_ebitMargin);


            double ans = ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double ans = revenues.getRevenuesList().get(i) * ebitMargin.getEBITMarginList().get(i);
            ebitIncomeList.add(ans);
        }


        BigDecimal ebitIncomeList11 = new BigDecimal(Double.toString(ebitIncomeList.get(11)));
        BigDecimal ebitIncomeListget0 = new BigDecimal(Double.toString(ebitIncomeList.get(0)));

        operatingIncomeGrew = ebitIncomeList11.subtract(ebitIncomeListget0).setScale(4, RoundingMode.HALF_UP).doubleValue();
        //operatingIncomeGrew=ebitIncomeList.get(11) - ebitIncomeList.get(0);
        ebitIncomeList.add(operatingIncomeGrew);
    }

    public ArrayList<Double> getEBITIncomeList() {
        return ebitIncomeList;
    }

    public double getOperatingIncomeGrew() {
        return operatingIncomeGrew;
    }

}

