package com.example.OutputSheet;

public class A21SumOfPV {

    public float getSumOfPV() {
        return sumOfPV;
    }

    public void setSumOfPV(A20PVCFOver10Year pvcfOver10Year, A19PVTerminalValue pvTerminalValue) {
        this.sumOfPV = pvcfOver10Year.getpVCFOver10Year() + pvTerminalValue.getpVTerminalValue();
    }

    float sumOfPV;



}
