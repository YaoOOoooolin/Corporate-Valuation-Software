package com.example.OutputSheet;

import com.example.StaticData.InputData;
import com.example.StaticData.OperatingLeaseConverter;
import com.example.StaticData.RDConverter;

import java.util.ArrayList;

public class A10NOL {
    ArrayList<Float> nolList=new ArrayList<>();


    public void setNolList(boolean B54,float B55,A5EBITIncome ebitIncome) {
        if(B54){
            nolList.add(B55);
        }
        else{
            nolList.add((float) 0);
        }

        for (int i = 1; i <=11; i++) {
            if(ebitIncome.getEBITIncomeList().get(i)<0){
                nolList.add(nolList.get(i-1)-ebitIncome.getEBITIncomeList().get(i));
            }
            else{
                if(nolList.get(i-1)>ebitIncome.getEBITIncomeList().get(i)){
                    nolList.add(nolList.get(i-1)-ebitIncome.getEBITIncomeList().get(i));
                }
                else {
                    nolList.add((float) 0);
                }
            }
        }

    }

    public ArrayList<Float> getNolList() {
        return nolList;
    }

}

class TestA10NOL{
    public static void main(String[] args) {
        InputData data = new InputData();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(), data.isB13(), olc.getF32(), rdc.getD39(), data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(), data.getB24(), data.getB26(), data.getB27());


        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate);


        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);


        A10NOL nol=new A10NOL();
        nol.setNolList(data.isB54(),data.getB55(), ebitIncome);
        System.out.println(nol.getNolList().toString());



    }
}


