package com.example.OutputSheet;

public class A18TerminalValue {
    public float getTerminalValue() {
        return terminalValue;
    }
    // Terminal Value = TerminalCashFlow / (Terminal Cost of Capital - Revenue groth rate in Terminal year)
    public void setTerminalValue(float A16TerminalCashFlow, float A17TerminalCostOfCapital, float M2terminalGrowthRate) {
        this.terminalValue = A16TerminalCashFlow / (A17TerminalCostOfCapital - M2terminalGrowthRate);
    }

    public float terminalValue;


}
