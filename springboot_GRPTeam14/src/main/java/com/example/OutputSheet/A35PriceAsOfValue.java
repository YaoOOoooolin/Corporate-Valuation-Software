package com.example.OutputSheet;

public class A35PriceAsOfValue {
    float priceAsPercentageOfValue;

    public float getPriceAsPercentageOfValue() {
        return priceAsPercentageOfValue;
    }

    public void setPriceAsPercentageOfValue(float price, float estimatedValue) {
        this.priceAsPercentageOfValue = price / estimatedValue;
    }
}
