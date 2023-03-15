package com.back.example.CostOfCapital;

public class CostB49WeightOfEquity {
    private double weightOfEquity;

    public double getWeightOfEquity() {
        return weightOfEquity;
    }

    /**
     * B48/E48. The weight of Equity in Cost of Capital
     * @param costB48MarketEquity the market Value of Equity
     * @param costE48MarketCapital the market Value of Capital
     */
    public void setWeightOfEquity(CostB48MarketEquity costB48MarketEquity, CostE48MarketCapital costE48MarketCapital) {
        this.weightOfEquity = costB48MarketEquity.getMarketEquity()/costE48MarketCapital.getMarketCapital();
    }
}
