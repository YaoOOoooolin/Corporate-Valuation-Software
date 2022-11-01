package com.example.OutputSheet;

public class A17TerminalCostOfCapital {
    public float terminalcostOfCapital;
    public void setTerminalcostOfCapital(boolean inputB41,float inputB42,boolean inputB57, float inputB58,float countryEquityRiskPremiumsB1,float inputB30) {
        //if Cost of capital after year 10 is Overrided
        if (inputB41){
            terminalcostOfCapital = inputB42;
        }
        //if Riskfree rate after year 10 is Overrided
        else{
            if(inputB57){
                terminalcostOfCapital= (float) (inputB58+0.8*(countryEquityRiskPremiumsB1));
            }
            //default riskfree rate
            else {
                terminalcostOfCapital=(float) (inputB30+0.8*(countryEquityRiskPremiumsB1));
            }
        }
    }
}
