package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

public class CostC50DebtComponent {
    private double debtComponent;

    public double getDebtComponent() {
        return debtComponent;
    }

    public void setDebtComponent(InputData inputData, CostB25PreTaxCostOfDebt costB25PreTaxCostOfDebt) {
        double taxRate = inputData.getB21();
        this.debtComponent = costB25PreTaxCostOfDebt.getPreTaxCostOfDebt() * (1 - taxRate);
    }
}
