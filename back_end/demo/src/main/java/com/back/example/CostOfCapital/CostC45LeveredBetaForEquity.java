package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

import java.util.Objects;

public class CostC45LeveredBetaForEquity {
    double leveredBetaForEquity;

    public double getLeveredBetaForEquity() {
        return leveredBetaForEquity;
    }

    public void setLeveredBetaForEquity(CostB11UnleveredBeta costB11UnleveredBeta, CostB48MarketEquity costB48MarketEquity, CostC48MarketDebt costC48MarketDebt) {
        double B11UnLeveredBeta = costB11UnleveredBeta.getUnLeveredBeta();
        double B26TaxRate = InputData.getB21();
        double B48MarketEquity = costB48MarketEquity.getMarketEquity();
        double C48MarketDebt = costC48MarketDebt.getMarketDebt();
        String type = InputForCapital.getB9ApproachForEstimatingBeta();
        if (Objects.equals(type, "Direct Input")) {
            this.leveredBetaForEquity = InputForCapital.getB10leveredBeta();
        } else {
            this.leveredBetaForEquity = B11UnLeveredBeta * (1 + (1 - B26TaxRate) * (C48MarketDebt / B48MarketEquity));
        }


    }
}
