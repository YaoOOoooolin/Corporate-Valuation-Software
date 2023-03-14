package com.back.example.CostOfCapital;

public class CostD49WeightOfPreferred {
    private double weightOfPreferredStock;

    public double getWeightOfPreferredStock() {
        return weightOfPreferredStock;
    }

    /**
     * D48/E48
     * @param costD48MarketPreferredStock
     * @param costE48MarketCapital
     */
    public void setWeightOfPreferredStock(CostD48MarketPreferredStock costD48MarketPreferredStock, CostE48MarketCapital costE48MarketCapital) {
        this.weightOfPreferredStock = costD48MarketPreferredStock.getMarketPreferredStock()/costE48MarketCapital.getMarketCapital();
    }
}
