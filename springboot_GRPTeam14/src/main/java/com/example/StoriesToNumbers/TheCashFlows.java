package com.example.StoriesToNumbers;

import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;
import com.example.OutputSheet.A2RevenueGrowthRate;
import com.example.OutputSheet.A3Revenues;
import com.example.OutputSheet.A4EBITMargin;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TheCashFlows {
//    static ArrayList<BigDecimal> EBITList = new ArrayList<>();

    public static void main(String[] args) {
        InputData data = new InputData();
        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);
        //Revenues outputs
        ArrayList<Float> revenuesList = revenues.getRevenuesList();

        //-------------------------------
        OperatingLeaseConverter olc =new OperatingLeaseConverter();
        RDConverter rdc=new RDConverter();

        A4EBITMargin ebitMargin=new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(),data.isB13(), olc.getF32(),rdc.getD39(),data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(),data.getB24(), data.getB26(), data.getB27());
        //Operating Margin outputs
        ArrayList<Float> ebitMarginList = ebitMargin.getEBITMarginList();

        //-------------------------------
        //EBIT outputs
        for (int i = 1; i < revenuesList.size(); i++) {
            Float revenue = revenuesList.get(i);
            Float EBITMargin = ebitMarginList.get(i);
            BigDecimal rv = new BigDecimal(revenue);
            BigDecimal multiply = BigDecimal.valueOf(EBITMargin).multiply(rv);
//            EBITList.set(i,multiply);
        }
        //-------------------------------
        //EBIT(1-t)



    }
}
