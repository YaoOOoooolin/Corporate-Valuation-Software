package com.back.example.CostOfCapital;

/**
 * B9 in Cost of capital worksheet:
 * Approach for estimating beta
 */
public class CostB9ApproachForEstimatingBeta {


    public int getApproachForEstimatingBeta() {
        return approachForEstimatingBeta;
    }

    /**
     *
     * @param approachForEstimatingBeta  <p>1 for Direct Input</p>
     *                                   <p>2 for Single Business(US)</p>
     *                                   <p>3 for Single Business(Global)</p>
     *                                   <p>4 for Multibusiness(US)</p>
     *                                   <p>5 for Multibusiness(Global)</p>
     */
    public void setApproachForEstimatingBeta(int approachForEstimatingBeta) {
        this.approachForEstimatingBeta = approachForEstimatingBeta;
    }

    int approachForEstimatingBeta;


}
