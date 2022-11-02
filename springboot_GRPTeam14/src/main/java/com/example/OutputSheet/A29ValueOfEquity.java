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
    public void setValueOfEquity(A24ValueOfOperatingAssets valueOfOperatingAssets, A25Debt debt, A26MinorityInterests minorityInterests, A27Cash cash, A28NonOperatingAssets nonOperatingAssets) {
        valueOfEquity = valueOfOperatingAssets.getValueOfOperatingAssets() - debt.getDebt() - minorityInterests.getMinorityInterests() + cash.getCash() + nonOperatingAssets.getNonOperatingAssets();
    }


}
