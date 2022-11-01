package com.example.OutputSheet;

public class A19PVTerminalValue {
    public float getpVTerminalValue() {
        return pVTerminalValue;
    }

    //PV(Terminal Value) = Terminal Value * Cumulated discount factor in year 10
    public void setpVTerminalValue(float TerminalValue, float discountFactor_in_year10) {
        this.pVTerminalValue = TerminalValue * discountFactor_in_year10;
    }

    float pVTerminalValue;

}
