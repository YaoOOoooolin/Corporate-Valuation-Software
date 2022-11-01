package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

import java.util.ArrayList;
public class A39InvestedCapital {

    public ArrayList<Float> investedCapitalList=new ArrayList<>();


    public void setInvestedCapitalList(Boolean inputB14,Boolean inputB13,float inputB12,float inputB15,float inputB11,float olcF33, float rdcD35,A8Reinvestment reinvestment) {
            float temp;

            if(inputB14){
                if (inputB13){
                    temp=inputB11+inputB12-inputB15+olcF33+rdcD35;
                }else {
                    temp=inputB11+inputB12-inputB15+olcF33;
                }
            }
            else {
                if (inputB13){
                    temp=inputB11+inputB12-inputB15+rdcD35;
                }
                else {
                    temp=inputB11+inputB12-inputB15;
                }
            }

            investedCapitalList.add(temp);

        for (int i = 1; i < 10; i++) {
            float temp_1=investedCapitalList.get(i-1)+reinvestment.getReinvestmentList().get(i);
            investedCapitalList.add(temp_1);
        }
    }


    public ArrayList<Float> getInvestedCapitalList() {
        return investedCapitalList;
    }
}


class TestA39InvestedCapital{
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
        ebit1t.setEBIT1tList(ebitIncome,data.getB20(),nol);

        A8Reinvestment reinvestment=new A8Reinvestment();

        reinvestment.setReinvestmentList(revenues,data.getB28(),revenueGrowthRate,roic,ebit1t);


        A39InvestedCapital investedCapital=new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(data.isB14(),data.isB13(),data.getB12(), data.getB15(), data.getB11(), olc.getF33(), rdc.getD35(),reinvestment);
        System.out.println(investedCapital.getInvestedCapitalList().toString());



    }



}
