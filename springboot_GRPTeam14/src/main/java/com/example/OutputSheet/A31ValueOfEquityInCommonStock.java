package com.example.OutputSheet;

public class A31ValueOfEquityInCommonStock {
    float valueOfEquityInCommonStock;

    public float getValueOfEquityInCommonStock() {
        return valueOfEquityInCommonStock;
    }

    public void setValueOfEquityInCommonStock(float valueOfEquity, float valueOfOptions) {
        this.valueOfEquityInCommonStock = valueOfEquity - valueOfOptions;
    }
}
