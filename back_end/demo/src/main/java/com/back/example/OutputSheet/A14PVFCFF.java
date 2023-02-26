package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A14PVFCFF {

    public ArrayList<Double> pvFcffList =new ArrayList<>();

    public void setPvFcffList(A9FCFF fcff, A13CumulatedDiscountFactor cumulatedDiscountFactor) {
        pvFcffList.add((double) 0);
        for (int i = 1; i <= 10; i++) {
            BigDecimal getFcffListi=new BigDecimal(Double.toString(fcff.getFcffList().get(i)));
            BigDecimal cumulatedDFListgeti=new BigDecimal(Double.toString(cumulatedDiscountFactor.cumulatedDFList.get(i)));
            BigDecimal ans=getFcffListi.multiply(cumulatedDFListgeti);
            double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

            pvFcffList.add(temp);
            //pvFcffList.add(fcff.getFcffList().get(i)*cumulatedDiscountFactor.cumulatedDFList.get(i));
        }
    }

    public ArrayList<Double> getPvFcffList() {
        return pvFcffList;
    }

}
