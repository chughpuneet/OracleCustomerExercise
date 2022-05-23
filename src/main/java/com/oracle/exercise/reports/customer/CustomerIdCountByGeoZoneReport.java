package com.oracle.exercise.reports.customer;

import com.oracle.exercise.customer.Customer;
import com.oracle.exercise.reports.Report;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Report generator of customer id count by Geo Zone
 */
public class CustomerIdCountByGeoZoneReport implements Report<Customer> {
    @Override
    public void generateReport(List<Customer> collection) {
        Map<String, Set<Integer>> customersIdByGeoZone = collection.stream().collect(
                Collectors.groupingBy(
                        Customer::getGeoZone,
                        Collectors.mapping(Customer :: getCustomerId, Collectors.toSet())));
        System.out.println("Number of unique customers id per Geo Zone");
        if(!customersIdByGeoZone.isEmpty()){
            customersIdByGeoZone.keySet().stream().forEach(geoZone -> {
                Set<Integer> customerIds = customersIdByGeoZone.get(geoZone);
                System.out.print(geoZone + " -> " );
                System.out.println(customerIds!=null?customerIds.size():0);
            });
        }else{
            System.out.println("No Customers By GeoZone found");
        }
    }
}
