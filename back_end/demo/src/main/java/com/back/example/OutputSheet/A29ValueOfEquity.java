/**

This class stores the amount of non-operating assets and provides methods to set and get the value of non-operating assets.
This class has the following public methods:
setNonOperatingAssets(double inputB16)
This method takes in a double value which represents the book value of non-operating assets and sets the inputB16
as the value of non-operating assets.
getNonOperatingAssets()
This method returns the value of non-operating assets stored in the nonOperatingAssets variable.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A29ValueOfEquity {
    double valueOfEquity;

    public double getValueOfEquity() {
        return valueOfEquity;
    }
    //B24 = Value of operating assets
    //B25 =  - Debt
    //B26 =  - Minority interests
    //B27 =  + Cash
    //B28 =  + Non-operating assets
    public void setValueOfEquity(A24ValueOfOperatingAssets valueOfOperatingAssets, A25Debt debt, A26MinorityInterests minorityInterests, A27Cash cash, A28NonOperatingAssets nonOperatingAssets) {

        BigDecimal getValueOfOperatingAssets=new BigDecimal(Double.toString(valueOfOperatingAssets.getValueOfOperatingAssets()));
        BigDecimal getDebt=new BigDecimal(Double.toString(debt.getDebt()));
        BigDecimal getMinorityInterests=new BigDecimal(Double.toString( minorityInterests.getMinorityInterests()));
        BigDecimal getCash =new BigDecimal(Double.toString(cash.getCash()));
        BigDecimal getNonOperatingAssets=new BigDecimal(Double.toString(nonOperatingAssets.getNonOperatingAssets()));

        BigDecimal ans1=getValueOfOperatingAssets.subtract(getDebt);
        BigDecimal ans2=ans1.subtract(getMinorityInterests);
        BigDecimal ans3=ans2.add(getCash);
        BigDecimal ans4=ans3.add(getNonOperatingAssets);
        double temp=ans4.setScale(4, RoundingMode.HALF_UP).doubleValue();


        valueOfEquity=temp;
       // valueOfEquity = valueOfOperatingAssets.getValueOfOperatingAssets() - debt.getDebt() - minorityInterests.getMinorityInterests() + cash.getCash() + nonOperatingAssets.getNonOperatingAssets();
    }


}
