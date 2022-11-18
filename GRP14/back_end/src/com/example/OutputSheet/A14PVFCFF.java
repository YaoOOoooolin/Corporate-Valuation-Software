package com.example.OutputSheet;

import java.util.ArrayList;

public class A14PVFCFF {

    public ArrayList<Float> pvFcffList =new ArrayList<>();

    public void setPvFcffList(A9FCFF fcff, A13CumulatedDiscountFactor cumulatedDiscountFactor) {
        pvFcffList.add((float) 0);
        for (int i = 1; i <= 10; i++) {
            pvFcffList.add(fcff.getFcffList().get(i)*cumulatedDiscountFactor.cumulatedDFList.get(i));
        }
    }

    public ArrayList<Float> getPvFcffList() {
        return pvFcffList;
    }

}
