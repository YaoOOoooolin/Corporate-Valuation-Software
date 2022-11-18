package com.example.OutputSheet;

public class A22ProbabilityOfFailure {

    public float getProbability_failure() {
        return probability_failure;
    }

    public void setProbability_failure(float inputB48, boolean inputB47) {
        //B47 = if probability of failure is overrided
        if (inputB47) {
            this.probability_failure = inputB48;
        } else {
            this.probability_failure = 0;
        }

    }
    float probability_failure;

}
