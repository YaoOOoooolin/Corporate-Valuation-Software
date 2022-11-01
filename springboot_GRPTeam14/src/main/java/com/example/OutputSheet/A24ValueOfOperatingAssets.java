package com.example.OutputSheet;

public class A24ValueOfOperatingAssets {
    public float getValueOfOperatingAssets() {
        return valueOfOperatingAssets;
    }

    public void setValueOfOperatingAssets(float sumOfPV, float proceedsIfFirmFails, float probailityOfFailure) {
        this.valueOfOperatingAssets = (sumOfPV + probailityOfFailure) * probailityOfFailure;
    }

    float valueOfOperatingAssets;

}
