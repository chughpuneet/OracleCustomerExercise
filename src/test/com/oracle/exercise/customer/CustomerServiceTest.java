package com.oracle.exercise.customer;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CustomerServiceTest {

    @Test
    public void saveCustomerTest(){
        CustomerService service = CustomerService.getService();
        service.saveCustomer(new Customer("2343225,2345,us_east,RedTeam,ProjectApple,3445s"));
        List<Customer> customers = service.getCustomers();
        Assert.assertTrue(customers.size() == 1);
        Customer customer = customers.get(0);
        Assert.assertTrue(customer.getCustomerId() == 2343225);
        Assert.assertTrue(customer.getContractId() == 2345);
        Assert.assertTrue(customer.getGeoZone().equals("us_east"));
        Assert.assertTrue(customer.getTeamCode().equals("RedTeam"));
        Assert.assertTrue(customer.getProjectCode().equals("ProjectApple"));
        Assert.assertTrue(customer.getBuildDuration().equals("3445s"));
    }

    @Test
    public void testSingleton(){
        CustomerService obj1 = CustomerService.getService();
        CustomerService obj2 = CustomerService.getService();
        Assert.assertTrue(obj1.equals(obj2));
    }

}
