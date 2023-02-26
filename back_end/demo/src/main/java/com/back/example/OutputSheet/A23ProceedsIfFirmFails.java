package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A23ProceedsIfFirmFails {

    public double getProceedsIfFirmFails() {
        return proceedsIfFirmFails;
    }

    public void setProceedsIfFirmFails(String inputB49, double inputB11, double inputB12, double inputB50, double inputB21 ) {
        BigDecimal big_11=new BigDecimal(Double.toString(inputB11));
        BigDecimal big_12=new BigDecimal(Double.toString(inputB12));
        BigDecimal big_50=new BigDecimal(Double.toString(inputB50));
        BigDecimal big_21=new BigDecimal(Double.toString(inputB21));


        if (inputB49.equals("V")) {
            BigDecimal ans1=big_11.add(big_12);
            BigDecimal ans2=ans1.multiply(big_50);
            double temp= ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.proceedsIfFirmFails=temp;
            //this.proceedsIfFirmFails = (inputB11 + inputB12) * inputB50;
        } else {
            BigDecimal ans1=big_21.add(big_50);
            double temp= ans1.setScale(4, RoundingMode.HALF_UP).doubleValue();

            this.proceedsIfFirmFails=temp;
           // this.proceedsIfFirmFails = inputB21* inputB50;
        }

    }

    double proceedsIfFirmFails;

}
