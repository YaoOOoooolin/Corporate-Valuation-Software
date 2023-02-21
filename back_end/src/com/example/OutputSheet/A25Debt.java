package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A25Debt {
    double debt;

    public double getDebt() {
        return debt;
    }

    public void setDebt(boolean inputB14, double olcC28, double inputB12) {
        if(inputB14){
            BigDecimal big_B12=new BigDecimal(Double.toString(inputB12));
            BigDecimal big_olcC28=new BigDecimal(Double.toString(olcC28));
            BigDecimal ans=big_B12.add(big_olcC28);
            double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.debt=temp;
            //this.debt = inputB12 + olcC28;
        }else {
            this.debt = inputB12;
        }

    }

}
