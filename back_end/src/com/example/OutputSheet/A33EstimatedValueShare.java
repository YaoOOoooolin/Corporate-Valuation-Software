package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A33EstimatedValueShare {
    double estimatedValueShare;

    public double getEstimatedValueShare() {
        return estimatedValueShare;
    }

    public void setEstimatedValueShare(A32NumberOfShares numberOfShares, A31ValueOfEquityInCommonStock valueOfEquityInCommonStock) {
        BigDecimal InCommonStock = new BigDecimal(Double.toString(valueOfEquityInCommonStock.getValueOfEquityInCommonStock()));
        BigDecimal NumberOfShares = new BigDecimal(Double.toString(numberOfShares.getNumberOfShares()));
        BigDecimal ans=InCommonStock.divide(NumberOfShares,20,RoundingMode.HALF_UP);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

        estimatedValueShare=temp;
       // estimatedValueShare =  valueOfEquityInCommonStock.getValueOfEquityInCommonStock()/numberOfShares.getNumberOfShares() ;
    }
}
