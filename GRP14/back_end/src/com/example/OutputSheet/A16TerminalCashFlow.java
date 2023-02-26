package com.example.OutputSheet;

public class A16TerminalCashFlow {

    public float terminalCashFlow;


    public void setTerminalCashFlow(A7EBIT1t ebit1t, A8Reinvestment reinvestment) {
        terminalCashFlow = ebit1t.getTerminalEBIT1t() - reinvestment.getTerminalreinvestment();
    }


    public float getTerminalCashFlow() {
        return terminalCashFlow;
    }


}
