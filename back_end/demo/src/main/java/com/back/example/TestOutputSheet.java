package com.back.example;

import com.back.StaticData.*;
import com.back.example.OutputSheet.*;
import com.back.example.StoriesToNumbers.TerminalValue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class TestOutputSheet {

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
    public static BigDecimal reinvestment_C_F12;

    public static double returnOnCapital_B13 = 0;
    public static double returnOnCapital_D13 = 0;
    public static double returnOnCapital_F13 = 0;

    public static double costOfCapital_d_C14 = 0;
    public static double costOfCapital_d_D14 = 0;
    public static double costOfCapital_d_F14 = 0;

    public static  ArrayList<Double> revenuesList = new ArrayList<>();
    public static  ArrayList<Double> ebitMarginList = new ArrayList<>();
    public static  ArrayList<Double> EBIT1_tList = new ArrayList<>();
    public static  ArrayList<Double> reinvestmentList = new ArrayList<>();
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
    public static double  valueOfEquity_D36 = 0;
    public static double   _valueOfEquityOptions = 0;
    public static double   numberOfShares_B32 = 0;
    public static double   valuePerShare = 0;


    /*
* 用方法来传参*/
    public static double outputB9(){
        InputData inputData = new InputData();
        revenues_a_C9 = inputData.getB25();
        revenues_a_D9 = revenues_a_F9;

        reinvestment_C_D12 = inputData.getB28();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov=new OptionValue();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();
        ArrayList<Double> rvg = revenueGrowthRate.getRevenueGrowthRateList();
        revenues_a_F9 = rvg.get(rvg.size()-1);

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);
        //Revenues List
        revenuesList = revenues.getRevenuesList();
        //B9 value
        revenues_a_B9 = revenuesList.get(0);
        return revenues_a_B9;
    }












    public static void main(String[] args) {
        InputData inputData = new InputData();
        revenues_a_C9 = inputData.getB25();
        revenues_a_D9 = revenues_a_F9;

        reinvestment_C_D12 = inputData.getB28();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov=new OptionValue();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();
        ArrayList<Double> rvg = revenueGrowthRate.getRevenueGrowthRateList();
        revenues_a_F9 = rvg.get(rvg.size()-1);

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);
        //Revenues List
        revenuesList = revenues.getRevenuesList();
        //B9 value
        revenues_a_B9 = revenuesList.get(0);
//        double temp = revenuesList.get(reinvestmentList.size() - 1);


        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());
        //EBIT List
        ebitMarginList = ebitMargin.getEBITMarginList();
        operatingMargin_b_B10 = ebitMarginList.get(0);
        operatingMargin_b_C10 = operatingMargin_b_B10;
        operatingMargin_b_F10 = ebitMarginList.get(ebitMarginList.size()-1);
        operatingMargin_b_D10 = operatingMargin_b_F10;

        //-------------------------------
        //EBIT outputs
        for (int i = 1; i < revenuesList.size(); i++) {
            double revenue = revenuesList.get(i);
            double EBITMargin = ebitMarginList.get(i);
            BigDecimal rv = new BigDecimal(revenue);
            BigDecimal multiply = BigDecimal.valueOf(EBITMargin).multiply(rv);
            EBITList.add(i-1,multiply);
        }

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);
        //EBIT(1-t) List
        EBIT1_tList = ebit1t.getEBIT1tList();


        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);
        ArrayList<Double> cl = costOfCapital.getCostOfCapitalList();
        costOfCapital_d_C14 = cl.get(0);
        costOfCapital_d_F14 = cl.get(cl.size()-1);
        costOfCapital_d_D14 = costOfCapital_d_F14;


        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);
        //Reinvestment List
        reinvestmentList = reinvestment.getReinvestmentList();

        //FCFF List
        for (int i = 0; i < EBIT1_tList.size(); i++) {
            double ET = EBIT1_tList.get(i);
            double RI = reinvestmentList.get(i);
            BigDecimal bg = new BigDecimal(RI);
            BigDecimal sub = BigDecimal.valueOf(ET).subtract(bg);
            FCFFList.add(sub);
        }


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);

        TerminalValue terminalValue=new TerminalValue();
        terminalValue.setTerminalvalue(costOfCapital,terminalCashFlow,revenueGrowthRate);
        terminalValue_InTheValue = terminalValue.getTerminalvalue();

        A6TaxRate taxRate = new A6TaxRate();
        taxRate.setTaxRateList(inputData.getB20());
        A9FCFF fcff = new A9FCFF();
        fcff.setFcffList(ebit1t, reinvestment);
        ArrayList<Double> tl = taxRate.getTaxRateList();
        taxRate_B11 = tl.get(0);
        taxRate_C11 = taxRate_B11;
        taxRate_F11 = tl.get(tl.size()-1);
        taxRate_D11 = taxRate_F11;

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital);

        A38SalesToCapitalRatio salesToCapitalRatio = new A38SalesToCapitalRatio();
        salesToCapitalRatio.setSalesToCapitalRatioList(inputData.getB28());

        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(inputData.isB14(), inputData.isB13(), inputData.getB12(), inputData.getB15(), inputData.getB11(), olc.getF33(), rdc.getD35(), reinvestment);

        roic.setRoicList(ebit1t, investedCapital);
        ArrayList<Double> roicList = roic.getRoicList();

        double terminalYear = roicList.get(roicList.size() - 1);
        double baseYear = roicList.get(0);
        returnOnCapital_B13 = baseYear;
        BigDecimal bg = new BigDecimal(terminalYear);
        reinvestment_C_F12 = BigDecimal.valueOf(baseYear).divide(bg, RoundingMode.HALF_DOWN);
        returnOnCapital_F13 = terminalYear;

        A14PVFCFF pvfcff = new A14PVFCFF();
        pvfcff.setPvFcffList(fcff, cumulatedDiscountFactor);

        A18TerminalValue a18terminalValue = new A18TerminalValue();
        a18terminalValue.setTerminalvalue(costOfCapital, terminalCashFlow, revenueGrowthRate);

        A19PVTerminalValue pvTerminalValue = new A19PVTerminalValue();
        pvTerminalValue.setpVTerminalValue(a18terminalValue, cumulatedDiscountFactor);
        PV_terminalValue_InTheValue = pvTerminalValue.getpVTerminalValue();

        A20PVCFOver10Year pvcfOver10Year = new A20PVCFOver10Year();
        pvcfOver10Year.setpVCFOver10Year(pvfcff);
        PV_CF_InTheValue = pvcfOver10Year.getpVCFOver10Year();

        A21SumOfPV sumOfPV = new A21SumOfPV();
        sumOfPV.setSumOfPV(pvcfOver10Year, pvTerminalValue);

        A22ProbabilityOfFailure probabilityOfFailure = new A22ProbabilityOfFailure();
        probabilityOfFailure.setProbability_failure(inputData.getB48(), inputData.isB47());

        A23ProceedsIfFirmFails proceedsIfFirmFails = new A23ProceedsIfFirmFails();
        proceedsIfFirmFails.setProceedsIfFirmFails(inputData.getB49(), inputData.getB11(), inputData.getB12(), inputData.getB50(),sumOfPV);

        A24ValueOfOperatingAssets valueOfOperatingAssets=new A24ValueOfOperatingAssets();
        valueOfOperatingAssets.setValueOfOperatingAssets(sumOfPV,proceedsIfFirmFails,probabilityOfFailure);

        A25Debt debt=new A25Debt();
        debt.setDebt(inputData.isB14(), olc.getC28(), inputData.getB12());

        A26MinorityInterests minorityInterests=new A26MinorityInterests();
        minorityInterests.setMinorityInterests(inputData.getB17());

        A27Cash cash=new A27Cash();
        cash.setCash(inputData.isB63(), inputData.getB15(), inputData.getB64(), inputData.getB65(), inputData.getB21());

        A28NonOperatingAssets nonOperatingAssets=new A28NonOperatingAssets();
        nonOperatingAssets.setNonOperatingAssets(inputData.getB16());

        A29ValueOfEquity valueOfEquity=new A29ValueOfEquity();
        valueOfEquity.setValueOfEquity(valueOfOperatingAssets,debt,minorityInterests,cash,nonOperatingAssets);

        A30ValueOfOptions valueOfOptions=new A30ValueOfOptions();
        valueOfOptions.setValueOfOptions(inputData.isB33(), ov.getD27());

        A31ValueOfEquityInCommonStock valueOfEquityInCommonStock=new A31ValueOfEquityInCommonStock();
        valueOfEquityInCommonStock.setValueOfEquityInCommonStock(valueOfEquity,valueOfOptions);

        A32NumberOfShares numberOfShares=new A32NumberOfShares();
        numberOfShares.setNumberOfShares(inputData.getB18());

        A33EstimatedValueShare estimatedValueShare=new A33EstimatedValueShare();
        estimatedValueShare.setEstimatedValueShare(numberOfShares,valueOfEquityInCommonStock);

        A34Price price=new A34Price();
        price.setPrice(inputData.getB19());

        A35PriceAsOfValue priceAsOfValue=new A35PriceAsOfValue();
        priceAsOfValue.setPriceAsPercentageOfValue(price,estimatedValueShare);






        System.out.println(" 2 Revenue growth rate       \t" + revenueGrowthRate.getRevenueGrowthRateList().toString());
        System.out.println(" 3 Revenues                  \t" + revenues.getRevenuesList().toString());
        System.out.println(" 4 EBIT (Operating) margin   \t" + ebitMargin.getEBITMarginList().toString());
        System.out.println(" 5 EBIT (Operating income)   \t" + ebitIncome.getEBITIncomeList().toString());
        System.out.println(" 6 Tax rate                  \t" + taxRate.getTaxRateList().toString());
        System.out.println(" 7 EBIT(1-t)                 \t" + ebit1t.getEBIT1tList().toString());
        System.out.println(" 8 Reinvestment              \t" + reinvestment.getReinvestmentList().toString());
        System.out.println(" 9 FCFF                      \t" + fcff.getFcffList().toString());
        System.out.println("10 NOL                       \t" + nol.getNolList().toString());
        System.out.println("12 Cost of capital           \t" + costOfCapital.getCostOfCapitalList().toString());
        System.out.println("13 Cumulated discount factor \t" + cumulatedDiscountFactor.getCumulatedDFList().toString());
        System.out.println("14 PV(FCFF)                  \t" + pvfcff.getPvFcffList().toString());
        System.out.println("\n");
        System.out.println("16 Terminal cash flow        \t" + fcff.getTerminalFcff());
        System.out.println("17 Terminal cost of capital  \t" + costOfCapital.getTerminalostOfCapital());
        System.out.println("18 Terminal value            \t" + a18terminalValue.getTerminalvalue());
        System.out.println("19 PV (Terminal value)       \t" + pvTerminalValue.getpVTerminalValue());
        System.out.println("20 PV (CF over next 10 years)\t" + pvcfOver10Year.getpVCFOver10Year());
        System.out.println("21 Sum of PV                 \t" + sumOfPV.getSumOfPV());
//        sumOfPV_B21 = sumOfPV.getSumOfPV();
        System.out.println("22 Probability of failure    \t" + probabilityOfFailure.getProbability_failure());
//        probabilityOfFailure_B22 = probabilityOfFailure.getProbability_failure();
        System.out.println("23 Proceeds if firm fails    \t" + proceedsIfFirmFails.getProceedsIfFirmFails());
//        proceedsIfFirmFails_B23 = proceedsIfFirmFails.getProceedsIfFirmFails();
        System.out.println("24 Value of operating asset \t"+valueOfOperatingAssets.getValueOfOperatingAssets());
        valueOfOperatingAssets_InTheValue = sumOfPV.getSumOfPV();
        adjustmentForDistress = valueOfOperatingAssets_InTheValue - valueOfOperatingAssets.getValueOfOperatingAssets();
        System.out.println("25 Debt                      \t"+debt.getDebt());
        System.out.println("A26 Minority interests       \t"+minorityInterests.getMinorityInterests());
        _debtAndMnorityInterests = debt.getDebt() + minorityInterests.getMinorityInterests();
        System.out.println("A27 Cach                     \t"+cash.getCash());
        System.out.println("A28 Non-operating assets     \t"+nonOperatingAssets.getNonOperatingAssets());
        cashAndOtherNon_operatingAssets = cash.getCash() + nonOperatingAssets.getNonOperatingAssets();
        valueOfEquity_D36 = (valueOfOperatingAssets_InTheValue) - (adjustmentForDistress) - (_debtAndMnorityInterests) + (cashAndOtherNon_operatingAssets);
        System.out.println("️A29 Value of equity         \t"+valueOfEquity.getValueOfEquity());
        System.out.println("A30 Value of options         \t"+valueOfOptions.getValueOfOptions());
        _valueOfEquityOptions = valueOfOptions.getValueOfOptions();
        System.out.println("️A31 Value of equity stock   \t"+valueOfEquityInCommonStock.getValueOfEquityInCommonStock());
        System.out.println("A32 Number of shares         \t"+numberOfShares.getNumberOfShares());
        numberOfShares_B32 = numberOfShares.getNumberOfShares();
        valuePerShare = (valueOfEquity_D36 - _valueOfEquityOptions) / numberOfShares_B32;
        System.out.println("️A33 Estimated value /share  \t"+estimatedValueShare.getEstimatedValueShare());
        System.out.println("A34 Price                    \t"+price.getPrice());
        System.out.println("️A35 Price as % of value     \t"+priceAsOfValue.getPriceAsPercentageOfValue());

        System.out.println("\n");
        System.out.println("38 Sales to capital ratio    \t" + salesToCapitalRatio.getSalesToCapitalRatioList().toString());
        System.out.println("39 Invested capital          \t" + investedCapital.getInvestedCapitalList().toString());
        double B39 = investedCapital.getInvestedCapitalList().get(0);
        double L39 = investedCapital.getInvestedCapitalList().get(investedCapital.getInvestedCapitalList().size() - 2);
        double diagnostics_B4 = L39 - B39;
        double B5 = ebitIncome.getEBITIncomeList().get(0);
        double L5 = ebitIncome.getEBITIncomeList().get(ebitIncome.getEBITIncomeList().size() - 2);
        double diagnostics_B5 = L5 - B5;
        returnOnCapital_D13 = diagnostics_B5/diagnostics_B4;
        System.out.println("40 ROIC                      \t" + roic.getRoicList().toString());
    }
}
