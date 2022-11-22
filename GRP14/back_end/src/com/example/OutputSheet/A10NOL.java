package com.example.OutputSheet;

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
