package com.oracle.exercise.customer;

import com.oracle.exercise.validation.exception.ConstraintViolations;
import com.oracle.exercise.validation.exception.ValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerTest {

    @Test
    public void testCustomerInvalidData(){
        ConstraintViolations t = Assert.assertThrows(ConstraintViolations.class,()->new Customer(",,,,,"));

        List<String> messages = t.getConstraintViolations().stream().map(ValidationException::getMessage).collect(Collectors.toList());

        Assert.assertTrue(messages.contains("customerId can only be number"));
        Assert.assertTrue(messages.contains("contractId can only be number"));
        Assert.assertTrue(messages.contains("teamCode cannot be blank"));
        Assert.assertTrue(messages.contains("projectCode cannot be blank"));
        Assert.assertTrue(messages.contains("buildDuration cannot be blank"));
        Assert.assertTrue(messages.contains("Value is null for field buildDuration"));
    }

    @Test
    public void testCustomerCreatedWithValidData(){
        Customer customer = new Customer("2343225,2345,us_east,RedTeam,ProjectApple,3445s");
        Assert.assertTrue(customer.getCustomerId() == 2343225);
        Assert.assertTrue(customer.getContractId() == 2345);
        Assert.assertTrue(customer.getGeoZone().equals("us_east"));
        Assert.assertTrue(customer.getTeamCode().equals("RedTeam"));
        Assert.assertTrue(customer.getProjectCode().equals("ProjectApple"));
        Assert.assertTrue(customer.getBuildDuration().equals("3445s"));
    }
}
