package com.back.example.CostOfCapital;

public class CostC48MarketDebt {
    private double marketDebt;

    public double getMarketDebt() {
        return marketDebt;
    }

    /**
     *  C41+C42+C43
     * @param costC41EstimatingMarketValueOfStraightDebt C41
     * @param costC42EstimatedValueOfStraightDebtInConvertible C42
     * @param costB33DebtValueOfOperatingLeases Also in the Cost of Capital worksheet C43
     */
    public void setMarketDebt(CostC41EstimatingMarketValueOfStraightDebt costC41EstimatingMarketValueOfStraightDebt, CostC42EstimatedValueOfStraightDebtInConvertible costC42EstimatedValueOfStraightDebtInConvertible, CostB33DebtValueOfOperatingLeases costB33DebtValueOfOperatingLeases) {
        this.marketDebt = costC41EstimatingMarketValueOfStraightDebt.getEstimatingMarketValueOfStraightDebt() + costC42EstimatedValueOfStraightDebtInConvertible.getEstimatedValueOfStraightDebtInConvertible() + costB33DebtValueOfOperatingLeases.getDebtValueOfOperatingLeases();
    }
}
