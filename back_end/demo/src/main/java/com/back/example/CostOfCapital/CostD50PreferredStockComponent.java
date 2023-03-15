package com.back.example.CostOfCapital;

public class CostD50PreferredStockComponent {
    private double preferredStockComponent;

    public double getPreferredStockComponent() {
        return preferredStockComponent;
    }

    /**
     * B38/B37
     */
    public void setPreferredStockComponent() {
        this.preferredStockComponent = InputForCapital.getB38AnnualDividedPerShare()/InputForCapital.getB37CurrentMarketPricePerShare();
    }
}
