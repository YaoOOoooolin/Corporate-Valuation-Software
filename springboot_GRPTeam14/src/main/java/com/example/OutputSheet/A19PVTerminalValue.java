package com.example.OutputSheet;

public class A19PVTerminalValue {
    public float getpVTerminalValue() {
        return pVTerminalValue;
    }


    public void setpVTerminalValue(A18TerminalValue terminalValue,A13CumulatedDiscountFactor cumulatedDiscountFactor ) {
        this.pVTerminalValue = terminalValue.getTerminalvalue()*cumulatedDiscountFactor.getCumulatedDFList().get(10);
    }

    float pVTerminalValue;



}
