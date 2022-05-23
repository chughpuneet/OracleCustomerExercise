package com.oracle.exercise.reports.customer;

import com.oracle.exercise.customer.Customer;
import com.oracle.exercise.reports.Report;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Report generator of Customer Ids by Geo Zone
 */
public class CustomerIdByGeoZoneReport implements Report<Customer> {
    @Override
    public void generateReport(List<Customer> collection) {
        Map<String, Set<Integer>> customersIdByGeoZone = collection.stream().collect(
                Collectors.groupingBy(
                        Customer::getGeoZone,
                        Collectors.mapping(Customer :: getCustomerId, Collectors.toSet())));
        System.out.println("Unique customers id per Geo Zone");
        if(!customersIdByGeoZone.isEmpty()){
            customersIdByGeoZone.keySet().stream().forEach(geoZone -> {
                Set<Integer> customerIds = customersIdByGeoZone.get(geoZone);
                String customerIdStr = "";
                if(customerIds != null){
                    customerIdStr = customerIds.stream().map(String::valueOf)
                            .collect(Collectors.joining(", "));
                }
                System.out.println(geoZone +" -> " + customerIdStr);
            });
        }else{
            System.out.println("No Customers By GeoZone found");
        }
    }
}
