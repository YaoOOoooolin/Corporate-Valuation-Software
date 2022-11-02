package com.example.OutputSheet;

public class A23ProceedsIfFirmFails {

    public float getProceedsIfFirmFails() {
        return proceedsIfFirmFails;
    }

    public void setProceedsIfFirmFails(String inputB49, float inputB11, float inputB12, float inputB50, float inputB21 ) {
        if (inputB49.equals("V")) {
            this.proceedsIfFirmFails = (inputB11 + inputB12) * inputB50;
        } else {
            this.proceedsIfFirmFails = inputB21* inputB50;
        }

    }

    float proceedsIfFirmFails;

}
