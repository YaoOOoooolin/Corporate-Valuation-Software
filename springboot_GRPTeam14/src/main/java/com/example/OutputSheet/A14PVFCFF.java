package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

import java.util.ArrayList;

public class A14PVFCFF {

    public ArrayList<Float> pvFcffList =new ArrayList<>();

    public void setPvFcffList(A9FCFF fcff, A13CumulatedDiscountFactor cumulatedDiscountFactor) {
        pvFcffList.add((float) 0);
        for (int i = 1; i <= 10; i++) {
            pvFcffList.add(fcff.getFcffList().get(i)*cumulatedDiscountFactor.cumulatedDFList.get(i));
        }
    }

    public ArrayList<Float> getPvFcffList() {
        return pvFcffList;
    }

}

class TestA14PVFCFF{
    public static void main(String[] args) {
        InputData data=new InputData();
        CountryEquityRiskPremiums cerp=new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital=new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(),data.getB42(),data.isB57(), data.getB58(), cerp.getB1(), data.getB30());
        costOfCapital.setCostOfCapitalList(data.getB31());

        A13CumulatedDiscountFactor cumulatedDF=new A13CumulatedDiscountFactor();
        cumulatedDF.setCumulatedDFListList(costOfCapital);

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);

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
        ebit1t.setEBIT1tList(ebitIncome,data.getB20(),nol);

        A8Reinvestment reinvestment=new A8Reinvestment();

        reinvestment.setReinvestmentList(revenues,data.getB28(),revenueGrowthRate,roic,ebit1t);

        A9FCFF fcff=new A9FCFF();
        fcff.setFcffList(ebit1t,reinvestment);

        A14PVFCFF pvfcff=new A14PVFCFF();
        pvfcff.setPvFcffList(fcff,cumulatedDF);
        System.out.println(pvfcff.getPvFcffList().toString());

    }
}