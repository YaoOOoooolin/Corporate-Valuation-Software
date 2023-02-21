package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A16TerminalCashFlow {

    public double terminalCashFlow;


    public void setTerminalCashFlow(A7EBIT1t ebit1t, A8Reinvestment reinvestment) {
        BigDecimal getTerminalEBIT1t =new BigDecimal(Double.toString(ebit1t.getTerminalEBIT1t()));
        BigDecimal getTerminalreinvestment =new BigDecimal(Double.toString(reinvestment.getTerminalreinvestment()));
        BigDecimal ans= getTerminalEBIT1t.subtract(getTerminalreinvestment);

        terminalCashFlow= ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
        //terminalCashFlow = ebit1t.getTerminalEBIT1t() - reinvestment.getTerminalreinvestment();
    }


    public double getTerminalCashFlow() {
        return terminalCashFlow;
    }


}
