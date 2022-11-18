package com.example.OutputSheet;

public class A18TerminalValue {

    public float terminalvalue;
    public void setTerminalvalue(A12CostOfCapital costOfCapital, A16TerminalCashFlow terminalCashFlow, A2RevenueGrowthRate revenueGrowthRate) {
        terminalvalue = terminalCashFlow.getTerminalCashFlow() / (costOfCapital.terminalostOfCapital - revenueGrowthRate.getTerminalRevenueGrowthRate());

    }

    public float getTerminalvalue() {
        return terminalvalue;
    }


}
