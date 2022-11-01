package com.example.OutputSheet;

public class A25Debt {
    float debt;

    public float getDebt() {
        return debt;
    }

    public void setDebt(boolean B14, float operatingLeaseConverter, float B12bookValueOfDebt) {
        if(B14){
            this.debt = B12bookValueOfDebt + operatingLeaseConverter;
        }else {
            this.debt = B12bookValueOfDebt;
        }

    }
}
