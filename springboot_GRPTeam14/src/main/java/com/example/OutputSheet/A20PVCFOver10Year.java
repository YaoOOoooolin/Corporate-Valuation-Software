package com.example.OutputSheet;

public class A20PVCFOver10Year {



    public float getpVCFOver10Year() {
        return pVCFOver10Year;
    }

    public void setpVCFOver10Year(A14PVFCFF pv_FCFF) {
        for (int i = 1; i <= 10; i++) {
            this.pVCFOver10Year += pv_FCFF.getPvFcffList().get(i);
        }
    }

    float pVCFOver10Year;
}
