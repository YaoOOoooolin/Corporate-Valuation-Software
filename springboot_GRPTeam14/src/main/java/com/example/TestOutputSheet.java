package com.example;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;
import com.example.OutputSheet.*;
import com.example.StoriesToNumbers.TerminalValue;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TestOutputSheet {
    //
    public static double revenues_a_B9 = 0;
    public static double revenues_a_C9 = 0;
    public static double revenues_a_D9 = 0;
    public static double revenues_a_F9 = 0;

    public static double operatingMargin_b_B10 = 0;
    public static double operatingMargin_b_C10 = 0;
    public static double operatingMargin_b_D10 = 0;
    public static double operatingMargin_b_F10 = 0;

    public static double taxRate_B11 = 0;
    public static double taxRate_C11 = 0;
    public static double taxRate_D11 = 0;
    public static double taxRate_F11 = 0;

    public static double reinvestment_C_D12 = 0;
    public static double reinvestment_C_F12 = 0;

    public static double returnOnCapital_B13 = 0;
    public static double returnOnCapital_D13 = 0;
    public static double returnOnCapital_F13 = 0;

    public static double costOfCapital_d_C14 = 0;
    public static double costOfCapital_d_D14 = 0;
    public static double costOfCapital_d_F14 = 0;

    public static  ArrayList<Float> revenuesList = new ArrayList<>();
    public static  ArrayList<Float> ebitMarginList = new ArrayList<>();
    public static  ArrayList<Float> EBIT1_tList = new ArrayList<>();
    public static  ArrayList<Float> reinvestmentList = new ArrayList<>();
    public static ArrayList<BigDecimal> EBITList = new ArrayList<>();
    public static ArrayList<BigDecimal> FCFFList = new ArrayList<>();


    //Terminal value
    public static double terminalValue_InTheValue = 0;
    public static double PV_terminalValue_InTheValue = 0;
    public static double PV_CF_InTheValue = 0;
    public static double valueOfOperatingAssets_InTheValue = 0;
    public static double adjustmentForDistress = 0;
    public static double  _debtAndMnorityInterests = 0;
    public static double  cashAndOtherNon_operatingAssets = 0;
    public static double  valueOfEquity = 0;
    public static double   _valueOfEquityOptions = 0;
    public static double   numberOfShares = 0;
    public static double   valuePerShare = 0;



    public static void main(String[] args) {
        InputData data=new InputData();
        revenues_a_C9 = data.getB25();
        revenues_a_D9 = revenues_a_F9;

        reinvestment_C_D12 = data.getB28();
//        revenues_a_F9 =
        CountryEquityRiskPremiums cerp=new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital=new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(),data.getB42(),data.isB57(), data.getB58(), cerp.getB1(), data.getB30());
        costOfCapital.setCostOfCapitalList(data.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();
        ArrayList<Float> rvg = revenueGrowthRate.getRevenueGrowthRateList();
        revenues_a_F9 = rvg.get(rvg.size()-1);

        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);
        //Revenues List
         revenuesList = revenues.getRevenuesList();
         //B9 value
        revenues_a_B9 = revenuesList.get(0);
        Float temp = revenuesList.get(reinvestmentList.size() - 1);
        //TODO
        reinvestment_C_F12 = 0;



        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(), data.isB13(), olc.getF32(), rdc.getD39(), data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(), data.getB24(), data.getB26(), data.getB27());
        //EBIT List
        ebitMarginList = ebitMargin.getEBITMarginList();
        operatingMargin_b_B10 = ebitMarginList.get(0);
        operatingMargin_b_C10 = operatingMargin_b_B10;
        operatingMargin_b_F10 = ebitMarginList.get(ebitMarginList.size()-1);
        operatingMargin_b_D10 = operatingMargin_b_F10;




        //-------------------------------
        //EBIT outputs
        for (int i = 1; i < revenuesList.size(); i++) {
            Float revenue = revenuesList.get(i);
            Float EBITMargin = ebitMarginList.get(i);
            BigDecimal rv = new BigDecimal(revenue);
            BigDecimal multiply = BigDecimal.valueOf(EBITMargin).multiply(rv);
            EBITList.set(i,multiply);
        }

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(data.isB54(), data.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(data.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, data.getB20(), nol);

        //EBIT(1-t) List
        EBIT1_tList = ebit1t.getEBIT1tList();


        costOfCapital.setTerminalostOfCapital(data.isB41(), data.getB42(), data.isB57(), data.getB58(), cerp.getB1(), data.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(data.isB44(), data.getB45(), costOfCapital);
        ArrayList<Float> cl = costOfCapital.getCostOfCapitalList();
        costOfCapital_d_C14 = cl.get(0);
        costOfCapital_d_F14 = cl.get(cl.size()-1);
        costOfCapital_d_D14 = costOfCapital_d_F14;

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, data.getB28(), revenueGrowthRate, roic, ebit1t);

        //Reinvestment List
        reinvestmentList = reinvestment.getReinvestmentList();

        //FCFF List
        for (int i = 0; i < EBIT1_tList.size(); i++) {
            Float ET = EBIT1_tList.get(i);
            Float RI = reinvestmentList.get(i);
            BigDecimal bg = new BigDecimal(RI);
            BigDecimal sub = BigDecimal.valueOf(ET).subtract(bg);
            FCFFList.set(i,sub);
        }


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);

        TerminalValue terminalValue=new TerminalValue();
        terminalValue.setTerminalvalue(costOfCapital,terminalCashFlow,revenueGrowthRate);
        terminalValue_InTheValue = terminalValue.getTerminalvalue();

        A6TaxRate taxRate=new A6TaxRate();
        taxRate.setTaxRateList(data.getB20());
        ArrayList<Float> tl = taxRate.getTaxRateList();
        taxRate_B11 = tl.get(0);
        taxRate_C11 = taxRate_B11;
        taxRate_F11 = tl.get(tl.size()-1);
        taxRate_D11 = taxRate_F11;

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
