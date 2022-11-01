package com.example.OutputSheet;

public class A27Cash {

    float cash;

    public float getCash() {
        return cash;
    }
    //B63 = if none of the cash is trapped (in foreign countries) and that there is no additional tax liability coming due and that cash is a neutral asset.
    //B64 = trapped cash (if taxes) or entire balance (if mistrust)
    //B65 = Average tax rate of the foreign markets where the cash is trapped
    public void setCash(boolean inputB63, float inputB15, float inputB64, float inputB65, float inputB21) {
        if (inputB63) {
            this.cash = inputB15 - inputB64 * (inputB21 - inputB65);
        } else {
            this.cash = inputB15;
        }
    }

}
