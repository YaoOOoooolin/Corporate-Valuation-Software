package com.back.example.CostOfCapital;
/**
 * B13 in Cost of capital worksheet:
 * What approach do you want to use to input ERP
 */
public class CostB13ApproachForERP {
    public int getApproachForERP() {
        return approachForERP;
    }

    /**
     *
     * @param approachForERP <p>1 for Direct Input</p>
     *                       <p>2 for Country of Incorporation</p>
     *                       <p>3 for Operating Countries</p>
     *                       <p>4 for Operating Regions</p>
     */
    public void setApproachForERP(int approachForERP) {
        this.approachForERP = approachForERP;
    }

    int approachForERP;

}
