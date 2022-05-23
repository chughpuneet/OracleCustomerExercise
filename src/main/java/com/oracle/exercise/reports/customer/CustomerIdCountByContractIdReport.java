package com.oracle.exercise.reports.customer;

import com.oracle.exercise.customer.Customer;
import com.oracle.exercise.reports.Report;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Report generator for customer id count by contract id
 */
public class CustomerIdCountByContractIdReport implements Report<Customer> {
    @Override
    public void generateReport(List<Customer> collection) {
        Map<Integer, Set<Integer>> customersIdByContractId = collection.stream().collect(
                Collectors.groupingBy(
                        Customer::getContractId,
                        Collectors.mapping(Customer :: getCustomerId, Collectors.toSet())));
        System.out.println("Number of unique customers id per Contract Id");
        if(!customersIdByContractId.isEmpty()){
            customersIdByContractId.keySet().stream().forEach(contractId -> {
                Set<Integer> customerIds = customersIdByContractId.get(contractId);
                System.out.print(contractId +" -> ");
                System.out.println(customerIds!=null?customerIds.size():0);
            });
        }else{
            System.out.println("No Customers found");
        }
    }
}
