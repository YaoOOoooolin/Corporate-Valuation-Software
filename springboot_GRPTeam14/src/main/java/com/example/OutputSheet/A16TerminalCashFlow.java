package com.example.OutputSheet;

import com.StaticData.CountryEquityRiskPremiums;
import com.StaticData.InputData;
import com.StaticData.OperatingLeaseConverter;
import com.StaticData.RDConverter;

public class A16TerminalCashFlow {

    public float terminalCashFlow;


    public void setTerminalCashFlow(A7EBIT1t ebit1t, A8Reinvestment reinvestment) {
        terminalCashFlow = ebit1t.getTerminalEBIT1t() - reinvestment.getTerminalreinvestment();
    }


    public float getTerminalCashFlow() {
        return terminalCashFlow;
    }


}
