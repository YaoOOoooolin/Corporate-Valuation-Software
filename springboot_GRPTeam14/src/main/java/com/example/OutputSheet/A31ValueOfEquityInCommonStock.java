package com.example.OutputSheet;

public class A31ValueOfEquityInCommonStock {
    float valueOfEquityInCommonStock;

    public float getValueOfEquityInCommonStock() {
        return valueOfEquityInCommonStock;
    }

    public void setValueOfEquityInCommonStock(A29ValueOfEquity valueOfEquity, A30ValueOfOptions valueOfOptions) {
        this.valueOfEquityInCommonStock = valueOfEquity.getValueOfEquity() - valueOfOptions.getValueOfOptions();
    }

}
