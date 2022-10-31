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

class TestA5EbitIncome {
    public static void main(String[] args) {
        InputData data = new InputData();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(), data.isB13(), olc.getF32(), rdc.getD39(), data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(), data.getB24(), data.getB26(), data.getB27());


        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);


        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        System.out.println(ebitIncome.getEBITIncomeList().toString());
        System.out.println("OperatingIncomeGrew= "+ebitIncome.getOperatingIncomeGrew());


    }
}
