package com.back.example.CostOfCapital;

public class CostC49WeightOfDebt {
    private double weightOfDebt;

    public double getWeightOfDebt() {
        return weightOfDebt;
    }

    /**
     * C48/E48. The weight of Debt in Cost of Capital
     * @param costC48MarketDebt the market Value of Debt
     * @param costE48MarketCapital the market Value of Capital
     */
    public void setWeightOfDebt(CostC48MarketDebt costC48MarketDebt, CostE48MarketCapital costE48MarketCapital) {
        this.weightOfDebt = costC48MarketDebt.getMarketDebt()/costE48MarketCapital.getMarketCapital();
    }
}
