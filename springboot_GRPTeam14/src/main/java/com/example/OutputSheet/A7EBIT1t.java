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
