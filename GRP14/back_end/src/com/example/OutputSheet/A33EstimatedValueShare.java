package com.example.OutputSheet;

public class A33EstimatedValueShare {
    float estimatedValueShare;

    public float getEstimatedValueShare() {
        return estimatedValueShare;
    }

    public void setEstimatedValueShare(A32NumberOfShares numberOfShares, A31ValueOfEquityInCommonStock valueOfEquityInCommonStock) {
        estimatedValueShare =  valueOfEquityInCommonStock.getValueOfEquityInCommonStock()/numberOfShares.getNumberOfShares() ;
    }
}
