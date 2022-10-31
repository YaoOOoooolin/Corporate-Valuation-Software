package com.example.OutputSheet;

import com.example.StaticData.CountryEquityRiskPremiums;
import com.example.StaticData.InputData;
import com.example.StaticData.OperatingLeaseConverter;
import com.example.StaticData.RDConverter;

import java.util.ArrayList;

public class A8Reinvestment {
    public ArrayList<Float> reinvestmentList = new ArrayList<>();
    public float terminalReinvestment;

    public void setReinvestmentList(A3Revenues revenues,float inputB28,A2RevenueGrowthRate revenueGrowthRate,A40ROIC roic,A7EBIT1t ebit1t) {
        reinvestmentList.add((float) 0);
        for (int i = 1; i <= 10; i++) {
            float temp = (revenues.getRevenuesList().get(i)-revenues.getRevenuesList().get(i-1))/inputB28;
            reinvestmentList.add(temp);
        }
       if(revenueGrowthRate.getTerminalRevenueGrowthRate()>0){
           float temp=(revenueGrowthRate.getTerminalRevenueGrowthRate()/roic.getTerminaLROIC())*ebit1t.getTerminalEBIT1t();
            reinvestmentList.add(temp);
       }
    }

    public ArrayList<Float> getReinvestmentList (){
        return reinvestmentList;
    }

 public float getTerminalreinvestment(){
        return reinvestmentList.get(11);
    }



}

class TestA8Reinvestment{

    public static void main(String[] args) {
        InputData data = new InputData();
        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);

        CountryEquityRiskPremiums cerp=new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital=new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(),data.getB42(),data.isB57(), data.getB58(), cerp.getB1(), data.getB30());

        A40ROIC roic=new A40ROIC();
        roic.setTerminaLROIC(data.isB44(),data.getB45(),costOfCapital);

        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(), data.isB13(), olc.getF32(), rdc.getD39(), data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(), data.getB24(), data.getB26(), data.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol=new A10NOL();
        nol.setNolList(data.isB54(),data.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(data.getB20(), revenues, ebitMargin);
        System.out.println(ebit1t.getTerminalEBIT1t());
        ebit1t.setEBIT1tList(ebitIncome,data.getB20(),nol);

        A8Reinvestment reinvestment=new A8Reinvestment();

        reinvestment.setReinvestmentList(revenues,data.getB28(),revenueGrowthRate,roic,ebit1t);
        System.out.println(reinvestment.getReinvestmentList().toString());



    }



}
