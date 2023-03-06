package com.back.example.CostOfCapital;

/**
 * B11 in Cost of capital worksheet:
 * Unlevered Beta
 */
public class CostB11UnleveredBeta {
    public double getUnLeveredBeta() {
        return unLeveredBeta;
    }

    public void setUnLeveredBeta(CostB9ApproachForEstimatingBeta B9, SingleUSBeta singleUSBeta, SingleGlobalBeta singleGlobalBeta, CostK48MultiUSBeta costK48MultiUSBeta, CostK64MultiGlobalBeta costK64MultiGlobalBeta) {
        int type = B9.getApproachForEstimatingBeta();
        if(type == 2){
            this.unLeveredBeta = singleUSBeta.getSingleUSBeta();
        } else if (type == 3) {
            this.unLeveredBeta = singleGlobalBeta.getSingleGlobalBeta();
        } else if (type == 4) {
            this.unLeveredBeta = costK48MultiUSBeta.getMultiUSBeta();
        } else if (type == 5) {
            this.unLeveredBeta = costK64MultiGlobalBeta.getMultiGlobalBeta();
        }
    }

    double unLeveredBeta;

}
