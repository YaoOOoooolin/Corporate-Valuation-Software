package com.example.OutputSheet;

public class A21SumOfPV {
    public float getSumOfPV() {
        return sumOfPV;
    }

    public void setSumOfPV(float pv_CFover10year, float pv_TerminalValue) {
        this.sumOfPV = pv_CFover10year + pv_TerminalValue;
    }

    float sumOfPV;


}
