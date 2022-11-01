package com.example.OutputSheet;

public class A23ProceedsIfFirmFails {
    public float getProceedsIfFirmFails() {
        return proceedsIfFirmFails;
    }

    public void setProceedsIfFirmFails(String B49, float B11BookValueOfEquity, float B12BookValueOfDebt, float B50distressProceeds, float B21marginalTaxRate ) {
        if (B49.equals("V")) {
            this.proceedsIfFirmFails = (B11BookValueOfEquity + B12BookValueOfDebt) * B50distressProceeds;
        } else {
            this.proceedsIfFirmFails = B21marginalTaxRate * B50distressProceeds;
        }

    }

    float proceedsIfFirmFails;

}
