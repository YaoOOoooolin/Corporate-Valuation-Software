package com.back.example.CostOfCapital;

public class CostD48MarketPreferredStock {
    private double marketPreferredStock;

    public double getMarketPreferredStock() {
        return marketPreferredStock;
    }

    /**
     * B36 * B37
     * Number of Preferred Shares * Current Market Price per Share
     */
    public void setMarketPreferredStock() {
        this.marketPreferredStock = InputForCapital.getB36NumberOfPreferredShares() * InputForCapital.getB37CurrentMarketPricePerShare();
    }
}
