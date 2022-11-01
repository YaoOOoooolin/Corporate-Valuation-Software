package com.example.OutputSheet;

public class A27Cash {
    float cash;

    public float getCash() {
        return cash;
    }
    //B63 = if none of the cash is trapped (in foreign countries) and that there is no additional tax liability coming due and that cash is a neutral asset.
    //B64 = trapped cash (if taxes) or entire balance (if mistrust)
    //B65 = Average tax rate of the foreign markets where the cash is trapped
    public void setCash(boolean B63, float B15cash, float B64trappedCash, float B65taxRate, float B21MarginalTaxRate) {
        if (B63) {
            this.cash = B15cash - B64trappedCash * (B21MarginalTaxRate - B65taxRate);
        } else {
            this.cash = B15cash;
        }
    }
}
