package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A19PVTerminalValue {
    public double getpVTerminalValue() {
        return pVTerminalValue;
    }


    public void setpVTerminalValue(A18TerminalValue terminalValue, A13CumulatedDiscountFactor cumulatedDiscountFactor) {
        BigDecimal getTerminalvalue=new BigDecimal(Double.toString(terminalValue.getTerminalvalue()));
        BigDecimal getCumulatedDFList10=new BigDecimal(Double.toString(cumulatedDiscountFactor.getCumulatedDFList().get(10)));
        BigDecimal ans=getTerminalvalue.multiply(getCumulatedDFList10);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

       this.pVTerminalValue=temp;
        //this.pVTerminalValue = terminalValue.getTerminalvalue() * cumulatedDiscountFactor.getCumulatedDFList().get(10);

    }

    double pVTerminalValue;


}
