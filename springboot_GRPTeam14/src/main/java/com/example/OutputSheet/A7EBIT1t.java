package com.example.OutputSheet;


import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

import java.util.ArrayList;

public class A7EBIT1t {
    public ArrayList<Float> ebit1tList = new ArrayList<>();
    public float terminalEBIT1t;


    public void setTerminalEBIT1t(float B20, A3Revenues revenues, A4EBITMargin ebitMargin) {
        terminalEBIT1t = (1 - B20) * revenues.getTerminalRevenues() * ebitMargin.getTerminalEBITMargin();
    }


    public void setEBIT1tList(A5EBITIncome ebitIncome, float B20,A10NOL nol) {

        if (ebitIncome.getEBITIncomeList().get(0) > 0) {
            ebit1tList.add(ebitIncome.getEBITIncomeList().get(0) * (1 - B20));
        } else {
            ebit1tList.add(ebitIncome.getEBITIncomeList().get(0));
        }

        for (int i = 1; i <=10 ; i++) {
            if(ebitIncome.getEBITIncomeList().get(i)>0){
                if(ebitIncome.getEBITIncomeList().get(i)<nol.getNolList().get(i-1)){
                    ebit1tList.add(ebitIncome.getEBITIncomeList().get(i));
                }
                else {
                    ebit1tList.add ( ebitIncome.getEBITIncomeList().get(i)-((ebitIncome.getEBITIncomeList().get(i)-nol.getNolList().get(i-1))*B20));
                }

            }
            else{
                ebit1tList.add(ebitIncome.getEBITIncomeList().get(i));
            }
        }




        ebit1tList.add(terminalEBIT1t);
    }

    public ArrayList<Float> getEBIT1tList() {
        return ebit1tList;
    }

    public float getTerminalEBIT1t() {
        return terminalEBIT1t;
    }
}

class TestA7EBIT1t {
    public static void main(String[] args) {
        InputData data = new InputData();
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

        A10NOL nol=new A10NOL();
        nol.setNolList(data.isB54(),data.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(data.getB20(), revenues, ebitMargin);
        System.out.println(ebit1t.getTerminalEBIT1t());
        ebit1t.setEBIT1tList(ebitIncome,data.getB20(),nol);
        System.out.println(ebit1t.getEBIT1tList().toString());


    }
}



