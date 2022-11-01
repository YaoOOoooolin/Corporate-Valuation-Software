package com.example;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;
import com.example.OutputSheet.*;
import com.example.StoriesToNumbers.TerminalValue;

public class TestOutputSheet {
    public static void main(String[] args) {
        InputData data=new InputData();
        CountryEquityRiskPremiums cerp=new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital=new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(),data.getB42(),data.isB57(), data.getB58(), cerp.getB1(), data.getB30());
        costOfCapital.setCostOfCapitalList(data.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);


        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(), data.isB13(), olc.getF32(), rdc.getD39(), data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(), data.getB24(), data.getB26(), data.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(data.isB54(), data.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(data.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, data.getB20(), nol);


        costOfCapital.setTerminalostOfCapital(data.isB41(), data.getB42(), data.isB57(), data.getB58(), cerp.getB1(), data.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(data.isB44(), data.getB45(), costOfCapital);


        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, data.getB28(), revenueGrowthRate, roic, ebit1t);


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);

        TerminalValue terminalValue=new TerminalValue();
        terminalValue.setTerminalvalue(costOfCapital,terminalCashFlow,revenueGrowthRate);

        A6TaxRate taxRate=new A6TaxRate();
        taxRate.setTaxRateList(data.getB20());
        A9FCFF fcff=new A9FCFF();
        fcff.setFcffList(ebit1t,reinvestment);


        A13CumulatedDiscountFactor cumulatedDiscountFactor=new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital);

        A14PVFCFF pvfcff=new A14PVFCFF();
        pvfcff.setPvFcffList(fcff,cumulatedDiscountFactor);

        System.out.println(" 2 Revenue growth rate      \t"+revenueGrowthRate.getRevenueGrowthRateList().toString());
        System.out.println(" 3 Revenues                 \t"+revenues.getRevenuesList().toString());
        System.out.println(" 4 EBIT (Operating) margin  \t"+ebitMargin.getEBITMarginList().toString());
        System.out.println(" 5 EBIT (Operating income)  \t"+ebitIncome.getEBITIncomeList().toString());
        System.out.println(" 6 Tax rate                 \t"+taxRate.getTaxRateList().toString());
        System.out.println(" 7 EBIT(1-t)                \t"+ebit1t.getEBIT1tList().toString());
        System.out.println(" 8 Reinvestment             \t"+reinvestment.getReinvestmentList().toString());
        System.out.println(" 9 FCFF                     \t"+fcff.getFcffList().toString());
        System.out.println("10 NOL                      \t"+nol.getNolList().toString());
        System.out.println("12 Cost of capital          \t"+costOfCapital.getCostOfCapitalList().toString());
        System.out.println("13 Cumulated discount factor\t"+cumulatedDiscountFactor.getCumulatedDFList().toString());
        System.out.println("14 PV(FCFF)                 \t"+pvfcff.getPvFcffList().toString());

        System.out.println("\n");
        System.out.println("16 Terminal cash flow       \t"+fcff.getTerminalFcff());
        System.out.println("17 Terminal cost of capital \t"+costOfCapital.getTerminalostOfCapital());
        System.out.println("18 Terminal value           \t"+terminalValue.getTerminalvalue());
    }
}
