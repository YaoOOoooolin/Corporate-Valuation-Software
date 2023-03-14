package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

public class CostB48MarketEquity {
    private double marketEquity;

    public double getMarketEquity() {
        return marketEquity;
    }

    /**
     * B6 * B7 in cost worksheet
     * @param inputData read data from inputSheet B18 and B19
     */
    public void setMarketEquity(InputData inputData) {
        double costB6NumberOfShares = inputData.getB18();
        double costB7PricePerShare = inputData.getB19();
        this.marketEquity = costB6NumberOfShares * costB7PricePerShare;
    }
}
