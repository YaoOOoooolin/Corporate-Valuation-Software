package com.back.example.OutputSheet;

public class A22ProbabilityOfFailure {

    public double getProbability_failure() {
        return probability_failure;
    }

    public void setProbability_failure(double inputB48, boolean inputB47) {
        //B47 = if probability of failure is overrided
        if (inputB47) {
            this.probability_failure = inputB48;
        } else {
            this.probability_failure = 0;
        }

    }
    double probability_failure;

}
