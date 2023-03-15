package com.back.example.CostOfCapital;

import com.back.example.CostOfCapital.InputForCapital;

import java.util.Objects;

/**
 * B13 in Cost of capital worksheet:
 * Equity Risk Premium used in cost of equity
 */
public class CostB15ERPInEquity {
    public double getERPInEquity() {
        return ERPInEquity;
    }

    /**
     *
     * Different approaching types for data
     * 1. Direct Input
     * 2. Country of Incorporation
     * 3. Operating Countries
     * 4. Operating Regions
     */
    public void setERPInEquity() {
        String type = InputForCapital.getB13ApproachForERP();
        if (Objects.equals(type, "Direct Input")) {
            this.ERPInEquity = InputForCapital.getB14DirectInputForERP();
        } else if (Objects.equals(type, "Country of Incorporation")) {
            this.ERPInEquity = InputForCapital.getCountryERP();
        } else if (Objects.equals(type, "Operating Countries")) {
            this.ERPInEquity = InputForCapital.getK18OperatingCountriesERP();
        } else if (Objects.equals(type, "Operating Regions")) {
            this.ERPInEquity = InputForCapital.getK32OperatingRegionERP();
        }
    }

    double ERPInEquity;

}
