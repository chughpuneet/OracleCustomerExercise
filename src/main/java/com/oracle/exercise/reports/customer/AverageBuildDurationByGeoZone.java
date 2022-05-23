package com.oracle.exercise.reports.customer;

import com.oracle.exercise.customer.Customer;
import com.oracle.exercise.reports.Report;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Report generator of average build durations by geo zone
 */
public class AverageBuildDurationByGeoZone implements Report<Customer> {

    @Override
    public void generateReport(List<Customer> collection) {
        //Get customerids by geo zone
        Map<String, List<Integer>> customersSummaryStatisticsByGeoZone = collection.stream().collect(
                Collectors.groupingBy(
                        Customer::getGeoZone,
                        Collectors.mapping(
                                customer -> {
                                    return Integer.valueOf(customer.getBuildDuration().split("s")[0]);
                                },
                                Collectors.toList())));
        System.out.println("Average Build Duration per Geo Zone");

        if(!customersSummaryStatisticsByGeoZone.isEmpty()){

            customersSummaryStatisticsByGeoZone.keySet().stream().forEach(geoZone -> {
                if(customersSummaryStatisticsByGeoZone.get(geoZone) != null){
                    IntSummaryStatistics buildDurationsStatistics
                            = customersSummaryStatisticsByGeoZone.get(geoZone).stream().mapToInt(x->x).summaryStatistics();
                    System.out.println(geoZone +" -> " + buildDurationsStatistics.getAverage());
                }else{
                    System.out.println(geoZone +" -> 0.0");
                }

            });
        }else{
            System.out.println("No Build duration By GeoZone found");
        }
    }
}
