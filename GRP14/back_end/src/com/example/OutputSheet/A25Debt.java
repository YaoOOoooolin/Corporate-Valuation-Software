package com.example.OutputSheet;

public class A25Debt {
    float debt;

    public float getDebt() {
        return debt;
    }

    public void setDebt(boolean inputB14, float olcC28, float inputB12) {
        if(inputB14){
            this.debt = inputB12 + olcC28;
        }else {
            this.debt = inputB12;
        }

    }

}
