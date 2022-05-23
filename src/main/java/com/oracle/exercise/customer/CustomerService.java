package com.oracle.exercise.customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for customers
 */
public final class CustomerService {

    private static CustomerService _this;

    /**
     * CustomerService is a singleton
     */
    private CustomerService(){
        super();
    }

    /**
     * Get a customer service
     * @return CustomerService
     */
    public static CustomerService getService(){
        if(null != _this){
            return _this;
        }

        synchronized (CustomerService.class){
            _this = new CustomerService();
            return _this;
        }
    }

    private List<Customer> customers = new ArrayList<Customer>();

    /**
     * Save a customer
     * @param customer, valid customer object
     */
    public void saveCustomer(Customer customer){
        customers.add(customer);
    }

    /**
     * List all of the customers saved
     * @return List<Customer>
     */
    public List<Customer> getCustomers(){
        return customers;
    }
}
