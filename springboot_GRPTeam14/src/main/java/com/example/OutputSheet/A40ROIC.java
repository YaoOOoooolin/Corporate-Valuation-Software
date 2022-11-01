package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

import java.util.ArrayList;

public class A40ROIC {

    public ArrayList<Float> roicList=new ArrayList<>();


    public float terminaLROIC;

    public void setTerminaLROIC(boolean inputB44,float inputB45,A12CostOfCapital costOfCapital) {
        if (inputB44){
            terminaLROIC=inputB45;
        }else {
            terminaLROIC=costOfCapital.getTerminalostOfCapital();
        }
    }

    public void setRoicList(A7EBIT1t ebit1t, A39InvestedCapital investedCapital){
        for (int i = 0; i <=9; i++) {
            float temp=ebit1t.getEBIT1tList().get(i)/investedCapital.investedCapitalList.get(i);
            roicList.add(temp);
        }
        roicList.add(terminaLROIC);

    }



    public ArrayList<Float> getRoicList(){
        return roicList;
    }
    public float getTerminaLROIC() {
        return terminaLROIC;
    }


}

class TestA40ROIC {
    public static void main(String[] args) {
        InputData data = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(), data.getB42(), data.isB57(), data.getB58(), cerp.getB1(), data.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(data.isB44(), data.getB45(), costOfCapital);
        //System.out.println(roic.getTerminaLROIC());


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

        A8Reinvestment reinvestment = new A8Reinvestment();

        reinvestment.setReinvestmentList(revenues, data.getB28(), revenueGrowthRate, roic, ebit1t);


        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(data.isB14(), data.isB13(), data.getB12(), data.getB15(), data.getB11(), olc.getF33(), rdc.getD35(), reinvestment);

        roic.setRoicList(ebit1t, investedCapital);

        System.out.println(roic.getRoicList().toString());
    }
}