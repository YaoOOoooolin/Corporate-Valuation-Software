package com.back.example.OutputSheet;

import com.back.StaticData.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A23ProceedsIfFirmFails {

    public double getProceedsIfFirmFails() {
        return proceedsIfFirmFails;
    }

    public void setProceedsIfFirmFails(String inputB49, double inputB11, double inputB12, double inputB50 ) {


        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov=new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);


        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);

        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);

        A9FCFF fcff = new A9FCFF();
        fcff.setFcffList(ebit1t, reinvestment);

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital);

        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(inputData.isB14(), inputData.isB13(), inputData.getB12(), inputData.getB15(), inputData.getB11(), olc.getF33(), rdc.getD35(), reinvestment);

        roic.setRoicList(ebit1t, investedCapital);
        A14PVFCFF pvfcff = new A14PVFCFF();
        pvfcff.setPvFcffList(fcff, cumulatedDiscountFactor);

        A18TerminalValue a18terminalValue = new A18TerminalValue();
        a18terminalValue.setTerminalvalue(costOfCapital, terminalCashFlow, revenueGrowthRate);

        A19PVTerminalValue pvTerminalValue = new A19PVTerminalValue();
        pvTerminalValue.setpVTerminalValue(a18terminalValue, cumulatedDiscountFactor);

        A20PVCFOver10Year pvcfOver10Year = new A20PVCFOver10Year();
        pvcfOver10Year.setpVCFOver10Year(pvfcff);

        A21SumOfPV sumOfPV = new A21SumOfPV();
        sumOfPV.setSumOfPV(pvcfOver10Year, pvTerminalValue);
        //System.out.println(sumOfPV.getSumOfPV());

        BigDecimal big_11=new BigDecimal(Double.toString(inputB11));
        BigDecimal big_12=new BigDecimal(Double.toString(inputB12));
        BigDecimal big_50=new BigDecimal(Double.toString(inputB50));
        BigDecimal big_21=new BigDecimal(Double.toString(sumOfPV.getSumOfPV()));


        if (inputB49.equals("B")) {
            BigDecimal ans1=big_11.add(big_12);
            BigDecimal ans2=ans1.multiply(big_50);
            double temp= ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.proceedsIfFirmFails=temp;
            //this.proceedsIfFirmFails = (inputB11 + inputB12) * inputB50;
        } else {
            BigDecimal ans1=big_21.multiply(big_50);
            double temp2= ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.proceedsIfFirmFails=temp2;
           // this.proceedsIfFirmFails = inputB21* inputB50;
        }

    }

    double proceedsIfFirmFails;

}

