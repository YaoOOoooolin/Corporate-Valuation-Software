package com.back.example.CostOfCapital;

public class CostE48MarketCapital {
    private double MarketCapital;

    public double getMarketCapital() {
        return MarketCapital;
    }

    /**
     * B48 + C48 + D48
     * @param costB48MarketEquity B48 Market Value of Equity
     * @param costC48MarketDebt C48 Market Value of Debt
     * @param costD48MarketPreferredStock D48 Market Value of Preferred Stock
     */
    public void setMarketCapital(CostB48MarketEquity costB48MarketEquity, CostC48MarketDebt costC48MarketDebt, CostD48MarketPreferredStock costD48MarketPreferredStock) {
        MarketCapital = costB48MarketEquity.getMarketEquity() + costC48MarketDebt.getMarketDebt() + costD48MarketPreferredStock.getMarketPreferredStock();
    }
}
