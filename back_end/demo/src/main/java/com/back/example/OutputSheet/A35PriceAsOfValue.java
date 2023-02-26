package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A35PriceAsOfValue {

    double priceAsPercentageOfValue;

    public double getPriceAsPercentageOfValue() {
        return priceAsPercentageOfValue;
    }

    public void setPriceAsPercentageOfValue(A34Price price, A33EstimatedValueShare estimatedValue) {
        BigDecimal Price = new BigDecimal(Double.toString(price.getPrice()));
        BigDecimal EstimatedValueShare = new BigDecimal(Double.toString(estimatedValue.getEstimatedValueShare()));
        BigDecimal ans=Price.divide(EstimatedValueShare,20, RoundingMode.HALF_UP);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

        priceAsPercentageOfValue=temp;
        //priceAsPercentageOfValue = price.getPrice()/ estimatedValue.getEstimatedValueShare();
    }

}
