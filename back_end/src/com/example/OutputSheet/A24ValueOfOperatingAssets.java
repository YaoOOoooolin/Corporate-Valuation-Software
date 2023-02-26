package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A24ValueOfOperatingAssets {
    public double getValueOfOperatingAssets() {
        return valueOfOperatingAssets;
    }

    public void setValueOfOperatingAssets(A21SumOfPV sumOfPV, A23ProceedsIfFirmFails proceedsIfFirmFails, A22ProbabilityOfFailure probailityOfFailure) {
        BigDecimal big_1=new BigDecimal("1");
        BigDecimal getSumOfPV=new BigDecimal(Double.toString(sumOfPV.getSumOfPV()));
        BigDecimal getProbability_failur=new BigDecimal(Double.toString(probailityOfFailure.getProbability_failure()));
        BigDecimal getProceedsIfFirmFails =new BigDecimal(Double.toString(proceedsIfFirmFails.getProceedsIfFirmFails()));
        BigDecimal ans1=big_1.subtract(getProbability_failur);
        BigDecimal ans2=getSumOfPV.multiply(ans1);
        BigDecimal ans3=getProbability_failur.multiply(getProceedsIfFirmFails);
        BigDecimal an4= ans2.add(ans3);
        double temp= an4.setScale(4, RoundingMode.HALF_UP).doubleValue();

        valueOfOperatingAssets=temp;
        //valueOfOperatingAssets = (sumOfPV.getSumOfPV() * (1 - probailityOfFailure.getProbability_failure())) + probailityOfFailure.getProbability_failure() * proceedsIfFirmFails.getProceedsIfFirmFails();
    }

    double valueOfOperatingAssets;
}
