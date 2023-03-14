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
        String syntheticRating = InputForCapital.B24SyntheticRatingType;
        double EBIT = inputData.getB9();
        double interestExpense = InputData.getB10();
        if(Objects.equals(ApproachType, "Direct Input")){
            this.PreTaxCostOfDebt = InputForCapital.getB22DirectInputPreTaxCostOfDebt();
        } else if (Objects.equals(ApproachType, "Actual rating")) {
            this.PreTaxCostOfDebt = inputData.getB30() + RatingSpread.ratingSpread.get(rating);
        } else if(Objects.equals(ApproachType, "Synthetic rating")){
            double interestConvergeRatio = EBIT/interestExpense;
            if(Objects.equals(syntheticRating, "1")){
                this.PreTaxCostOfDebt = SyntheticRating.LargerSaferFirms(interestConvergeRatio);
            } else if(Objects.equals(syntheticRating, "2")){
                this.PreTaxCostOfDebt = SyntheticRating.SmallerRiskierFirms(interestConvergeRatio);
            }
        }
    }

    double PreTaxCostOfDebt;

}
