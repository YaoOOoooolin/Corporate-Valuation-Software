package com.example.OutputSheet;

public class A22ProbabilityOfFailure {
    public float getProbability_failure() {
        return probability_failure;
    }

    public void setProbability_failure(float B48probability_failure, boolean B47) {
        //B47 = if probability of failure is overrided
        if (B47) {
            this.probability_failure = B48probability_failure;
        } else {
            this.probability_failure = 0;
        }

    }

    float probability_failure;
}
