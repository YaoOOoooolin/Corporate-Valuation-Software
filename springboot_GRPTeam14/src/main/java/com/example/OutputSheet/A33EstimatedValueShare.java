package com.example.OutputSheet;

public class A33EstimatedValueShare {
    float estimatedValueShare;

    public float getEstimatedValueShare() {
        return estimatedValueShare;
    }

    public void setEstimatedValueShare(float numberOfShares, float valueOfEquityInCommonStock) {
        this.estimatedValueShare = valueOfEquityInCommonStock / numberOfShares;
    }
}
