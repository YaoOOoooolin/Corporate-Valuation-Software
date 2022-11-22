package com.example.OutputSheet;

public class A35PriceAsOfValue {

    float priceAsPercentageOfValue;

    public float getPriceAsPercentageOfValue() {
        return priceAsPercentageOfValue;
    }

    public void setPriceAsPercentageOfValue(A34Price price, A33EstimatedValueShare estimatedValue) {
        this.priceAsPercentageOfValue = price.getPrice()/ estimatedValue.getEstimatedValueShare();
    }

}
