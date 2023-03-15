package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

public class CostB50EquityComponent {
    private double equityComponent;

    public double getEquityComponent() {
        return equityComponent;
    }

    public void setEquityComponent(CostC45LeveredBetaForEquity costC45LeveredBetaForEquity, CostB15ERPInEquity costB15ERPInEquity) {
        double B12riskFreeRate = InputData.getB30();
        double C45leveredBeta = costC45LeveredBetaForEquity.getLeveredBetaForEquity();
        double B15ERP = costB15ERPInEquity.getERPInEquity();
        this.equityComponent = B12riskFreeRate + C45leveredBeta * B15ERP;
    }
}
