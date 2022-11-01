package com.example.OutputSheet;

public class A29ValueOfEquity {
    float valueOfEquity;

    public float getValueOfEquity() {
        return valueOfEquity;
    }
    //B24 = Value of operating assets
    //B25 =  - Debt
    //B26 =  - Minority interests
    //B27 =  + Cash
    //B28 =  + Non-operating assets
    public void setValueOfEquity(float B24, float B25, float B26, float B27, float B28) {
        this.valueOfEquity = B24 - B25 - B26 + B27 + B28;
    }
}
