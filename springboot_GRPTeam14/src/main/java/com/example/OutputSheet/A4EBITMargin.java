package com.example.OutputSheet;

import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

import java.util.ArrayList;

public class A4EBITMargin {

    public ArrayList<Float> ebitMarginList = new ArrayList<>();



    public float baseIncome;  //firstly bulid  baseIncome

    public float getBaseIncome() {
        return baseIncome;
    }
    public void setBaseIncome(boolean inputB14, boolean inputB13, float olcF32, float rdcD39, float inputB9) {
        if (inputB14) {
            if (inputB13) {
                baseIncome = inputB9 + olcF32 + rdcD39;
            } else {
                baseIncome = inputB9 + olcF32;
            }
        } else {
            if (inputB13) {
                baseIncome = inputB9 + rdcD39;
            } else {
                baseIncome = inputB9;
            }
        }
    }

    public void setEBITMarginList(float inputB8, float inputB24, float inputB26, float inputB27) {
        ebitMarginList.add(baseIncome / inputB8);
        ebitMarginList.add(inputB24);
        for (int i = 2; i <= 10; i++) {
            if (i > inputB27) {
                ebitMarginList.add(inputB26);
            } else {
                float temp = inputB26 - ((inputB26 - ebitMarginList.get(1)) / inputB27 * (inputB27 - i));
                ebitMarginList.add(temp);
            }
        }
        ebitMarginList.add(ebitMarginList.get(10));
    }


    public ArrayList<Float> getEBITMarginList(){
        return ebitMarginList;
    }

    public float getTerminalEBITMargin(){
        return ebitMarginList.get(11);
    }

}

class TestA4EBITMargin{
    public static void main(String[] args) {
        InputData data=new InputData();
        OperatingLeaseConverter olc=new OperatingLeaseConverter();
        RDConverter rdc=new RDConverter();

        A4EBITMargin ebitMargin=new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(),data.isB13(), olc.getF32(),rdc.getD39(),data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(),data.getB24(), data.getB26(), data.getB27());

        System.out.println(ebitMargin.getEBITMarginList().toString());
        System.out.println(ebitMargin.getTerminalEBITMargin());

    }





}


