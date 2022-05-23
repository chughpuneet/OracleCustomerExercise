package com.oracle.exercise;

import com.oracle.exercise.customer.Customer;
import com.oracle.exercise.customer.CustomerService;
import com.oracle.exercise.reports.factory.CustomerReports;
import com.oracle.exercise.reports.factory.ReportFactory;
import com.oracle.exercise.validation.exception.ConstraintViolations;
import com.oracle.exercise.validation.exception.ValidationException;
import com.oracle.exercise.validation.validator.StringInputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Press ctrl+d to finish in windows or ctrl+z in other env");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String customerStr = scanner.next();
            if(null == customerStr || customerStr.trim().isEmpty()){
                System.out.println("Please enter Value");
            }else
                try {
                    if(StringInputValidator.getStringInputValidator().validate(customerStr)){
                        Customer customer = new Customer(customerStr);
                        CustomerService.getService().saveCustomer(customer);
                        System.out.println("Customer details entered successfully");
                    }
                }catch (ConstraintViolations e) {
                    e.print();
                }catch (ValidationException e) {
                    System.out.println(e.getMessage());
                }
        }
        final List<Customer> customers = CustomerService.getService().getCustomers();

        //generating all of the reports
        Arrays.stream(CustomerReports.values()).map(CustomerReports::getReportName).
                forEach(reportName -> {
                    System.out.println(".......................................");
                    ReportFactory.getFactory().getReport(reportName).generateReport(customers);
                });
    }

}
