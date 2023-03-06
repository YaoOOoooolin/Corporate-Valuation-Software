package com.back.example.CostOfCapital;

/**
 * B13 in Cost of capital worksheet:
 * Equity Risk Premium used in cost of equity
 */
public class CostB15ERPInEquity {
    public double getERPInEquity() {
        return ERPInEquity;
    }

    public void setERPInEquity(CostB13ApproachForERP costB13ApproachForERP, CostB14DirectInputForERP costB14DirectInputForERP, CountryERP countryERP, CostK18OperatingCountriesERP costK18OperatingCountriesERP, CostK32OperatingRegionERP costK32OperatingRegionERP) {
        int type = costB13ApproachForERP.getApproachForERP();
        if(type == 1){
            this.ERPInEquity = costB14DirectInputForERP.getDirectInputForERP();
        } else if(type == 2){
            this.ERPInEquity = countryERP.getCountryERP();
        } else if (type == 3) {
            this.ERPInEquity = costK18OperatingCountriesERP.getOperatingCountriesERP();
        } else if(type == 4) {
            this.ERPInEquity = costK32OperatingRegionERP.getOperatingRegionERP();
        }
    }

    double ERPInEquity;

}
