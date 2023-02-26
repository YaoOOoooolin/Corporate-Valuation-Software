package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A20PVCFOver10Year {



    public double getpVCFOver10Year() {
        return pVCFOver10Year;
    }

    public void setpVCFOver10Year(A14PVFCFF pv_FCFF) {
        for (int i = 1; i <= 10; i++) {
            BigDecimal big_pVCFOver10Year=new BigDecimal(Double.toString(pVCFOver10Year));
            BigDecimal getPvFcffListi=new BigDecimal(Double.toString(pv_FCFF.getPvFcffList().get(i)));
            BigDecimal ans=big_pVCFOver10Year.add(getPvFcffListi);
            double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

            pVCFOver10Year=temp;
            //pVCFOver10Year += pv_FCFF.getPvFcffList().get(i);
        }
    }

    double pVCFOver10Year;
}
