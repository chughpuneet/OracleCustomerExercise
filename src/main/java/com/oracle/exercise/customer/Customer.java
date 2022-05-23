package com.oracle.exercise.customer;

import com.oracle.exercise.validation.constraint.Min;
import com.oracle.exercise.validation.constraint.NotBlank;
import com.oracle.exercise.validation.constraint.Pattern;
import com.oracle.exercise.validation.exception.ConstraintViolations;
import com.oracle.exercise.validation.validator.Validator;

public final class Customer {

    @Min(value = 1)
    private Integer customerId;

    @Min(value = 1)
    private Integer contractId;

    @NotBlank
    private String geoZone;

    @NotBlank
    private String teamCode;

    @NotBlank
    private String projectCode;

    @NotBlank
    @Pattern(value = "\\d+[s]")
    private String buildDuration;

    /**
     * Save a customer object from the input string
     *
     * @param commaSepStr comma seperated input String
     *
     * @throws ConstraintViolations throws when a validation is failed in input String
     */
    public Customer(String commaSepStr) throws ConstraintViolations {
        String[] customerAttr = commaSepStr.split(",");
        for(int i=0; i<customerAttr.length;i++){
            switch (i){
                case 0:
                    this.customerId = getIntegerValue(customerAttr[i]);
                    break;
                case 1:
                    this.contractId = getIntegerValue(customerAttr[i]);
                    break;
                case 2:
                    this.geoZone = customerAttr[i];
                    break;
                case 3:
                    this.teamCode = customerAttr[i];
                    break;
                case 4:
                    this.projectCode = customerAttr[i];
                    break;
                case 5:
                    this.buildDuration = customerAttr[i];
                    break;
            }
        }
        //validate fields
        Validator<Customer> validator = new Validator<>();
        //it will throw exception, in case object is invalid and cause the object to be not assigned
        //and eligible for GC
        validator.validateFields(this);
    }

    private Integer getIntegerValue(String value){
        try{
            return Integer.valueOf(value);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    @Override
    public String toString(){
        return  "customerId = " + customerId + " contractId = " + contractId + " geoZone = " + geoZone
                + " teamCode = " + teamCode + " projectCode = " + projectCode + " buildDuration = " + buildDuration;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public String getGeoZone() {
        return geoZone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getBuildDuration() {
        return buildDuration;
    }
}
