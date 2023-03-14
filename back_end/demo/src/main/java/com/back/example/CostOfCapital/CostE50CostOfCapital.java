package com.back.example.CostOfCapital;

public class CostE50CostOfCapital {
    private double costOfCapital;

    public double getCostOfCapital() {
        return costOfCapital;
    }

    /**
     * B49*B50+C49*C50+D49*D50
     * @param costB49WeightOfEquity
     * @param costB50EquityComponent
     * @param costC49WeightOfDebt
     * @param costC50DebtComponent
     * @param costD49WeightOfPreferred
     */
    public void setCostOfCapital(CostB49WeightOfEquity costB49WeightOfEquity, CostB50EquityComponent costB50EquityComponent, CostC49WeightOfDebt costC49WeightOfDebt, CostC50DebtComponent costC50DebtComponent, CostD49WeightOfPreferred costD49WeightOfPreferred) {
        this.costOfCapital = costB49WeightOfEquity.getWeightOfEquity() * costB50EquityComponent.getEquityComponent() + costC49WeightOfDebt.getWeightOfDebt() * costC50DebtComponent.getDebtComponent() + costD49WeightOfPreferred.getWeightOfPreferredStock() * costC50DebtComponent.getDebtComponent();
    }
}
