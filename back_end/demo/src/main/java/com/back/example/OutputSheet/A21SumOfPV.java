package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A21SumOfPV {

    public double getSumOfPV() {
        return sumOfPV;
    }

    public void setSumOfPV(A20PVCFOver10Year pvcfOver10Year, A19PVTerminalValue pvTerminalValue) {
        BigDecimal getpVCFOver10Year=new BigDecimal(Double.toString(pvcfOver10Year.getpVCFOver10Year()));
        BigDecimal getpVTerminalValue=new BigDecimal(Double.toString(pvTerminalValue.getpVTerminalValue()));
        BigDecimal ans=getpVCFOver10Year.add(getpVTerminalValue);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();


        sumOfPV=temp;
        //sumOfPV = pvcfOver10Year.getpVCFOver10Year() + pvTerminalValue.getpVTerminalValue();
    }

    double sumOfPV;



}
