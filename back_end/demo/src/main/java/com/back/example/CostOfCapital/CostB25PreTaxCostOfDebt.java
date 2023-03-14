package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;


import java.util.Objects;

public class CostB25PreTaxCostOfDebt {
    public double getPreTaxCostOfDebt() {
        return PreTaxCostOfDebt;
    }

    public void setPreTaxCostOfDebt(InputData inputData) {
        String ApproachType = InputForCapital.B21ApproachForPreTaxCostOfDebt;
        String rating = InputForCapital.B23ActualRating;
        if(Objects.equals(ApproachType, "Direct Input")){
            this.PreTaxCostOfDebt = InputForCapital.getB22DirectInputPreTaxCostOfDebt();
        } else if (Objects.equals(ApproachType, "Actual rating")) {
            this.PreTaxCostOfDebt = inputData.getB30() + RatingSpread.ratingSpread.get(rating);
        } else if(Objects.equals(ApproachType, "Synthetic rating")){
            this.PreTaxCostOfDebt = 0; //remain completed
        }
    }

    double PreTaxCostOfDebt;

}
