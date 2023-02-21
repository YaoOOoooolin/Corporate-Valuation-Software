package com.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A18TerminalValue {

    public double terminalvalue;
    public void setTerminalvalue(A12CostOfCapital costOfCapital, A16TerminalCashFlow terminalCashFlow, A2RevenueGrowthRate revenueGrowthRate) {

        BigDecimal terminalostOfCapital =new BigDecimal(Double.toString(costOfCapital.terminalostOfCapital));
        BigDecimal getTerminalRevenueGrowthRate =new BigDecimal(Double.toString(revenueGrowthRate.getTerminalRevenueGrowthRate()));
        BigDecimal getTerminalCashFlow=new BigDecimal(Double.toString(terminalCashFlow.getTerminalCashFlow()));
        BigDecimal ans1=terminalostOfCapital.subtract(getTerminalRevenueGrowthRate);
        BigDecimal ans2=getTerminalCashFlow.divide(ans1,20, RoundingMode.HALF_UP);


        double temp=ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();
        terminalvalue=temp;
        //terminalvalue = terminalCashFlow.getTerminalCashFlow() / (costOfCapital.terminalostOfCapital - revenueGrowthRate.getTerminalRevenueGrowthRate());

    }

    public double getTerminalvalue() {
        return terminalvalue;
    }


}
