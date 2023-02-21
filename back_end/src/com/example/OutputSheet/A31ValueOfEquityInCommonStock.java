package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A31ValueOfEquityInCommonStock {
    double valueOfEquityInCommonStock;

    public double getValueOfEquityInCommonStock() {
        return valueOfEquityInCommonStock;
    }

    public void setValueOfEquityInCommonStock(A29ValueOfEquity valueOfEquity, A30ValueOfOptions valueOfOptions) {
        BigDecimal getValueOfEquity = new BigDecimal(Double.toString(valueOfEquity.getValueOfEquity()));
        BigDecimal getValueOfOptions = new BigDecimal(Double.toString(valueOfOptions.getValueOfOptions()));
        BigDecimal ans=getValueOfEquity.subtract(getValueOfOptions);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();


        valueOfEquityInCommonStock=temp;
        //valueOfEquityInCommonStock = valueOfEquity.getValueOfEquity() - valueOfOptions.getValueOfOptions();
    }

}
