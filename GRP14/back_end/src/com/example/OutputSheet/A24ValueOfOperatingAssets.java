package com.example.OutputSheet;

public class A24ValueOfOperatingAssets {
    public float getValueOfOperatingAssets() {
        return valueOfOperatingAssets;
    }

    public void setValueOfOperatingAssets(A21SumOfPV sumOfPV, A23ProceedsIfFirmFails proceedsIfFirmFails, A22ProbabilityOfFailure probailityOfFailure) {

       valueOfOperatingAssets = (sumOfPV.getSumOfPV() *(1- probailityOfFailure.getProbability_failure()) )+ probailityOfFailure.getProbability_failure() * proceedsIfFirmFails.getProceedsIfFirmFails();
    }

    float valueOfOperatingAssets;
}
