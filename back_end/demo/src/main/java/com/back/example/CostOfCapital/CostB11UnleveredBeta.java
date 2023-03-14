package com.back.example.CostOfCapital;


import java.util.Objects;

/**
 * B11 in Cost of capital worksheet:
 * Unlevered Beta
 */
public class CostB11UnleveredBeta {
    public double getUnLeveredBeta() {
        return unLeveredBeta;
    }

    /**
     *
     * Different types of data approaching:
     * <p>2. Single Business(US)</p>
     * <p>3. Single Business(Global)</p>
     * <p>4. Multibusiness(US)</p>
     * <p>5. Multibusiness(Global)</p>
     */
    public void setUnLeveredBeta() {
        String type = InputForCapital.getB9ApproachForEstimatingBeta();
        if(Objects.equals(type, "Single Business(US)")){
            this.unLeveredBeta = InputForCapital.getSingleUSBeta();
        } else if (Objects.equals(type, "Single Business(Global)")) {
            this.unLeveredBeta = InputForCapital.getSingleGlobalBeta();
        } else if (Objects.equals(type, "Multibusiness(US)")) {
            this.unLeveredBeta = InputForCapital.getK48MultiUSBeta();
        } else if (Objects.equals(type, "Multibusiness(Global)")) {
            this.unLeveredBeta = InputForCapital.getK64MultiGlobalBeta();
        }
    }

    double unLeveredBeta;

}
