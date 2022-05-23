package com.oracle.exercise.reports.factory;

import com.oracle.exercise.customer.Customer;
import com.oracle.exercise.reports.Report;
import com.oracle.exercise.reports.customer.AverageBuildDurationByGeoZone;
import com.oracle.exercise.reports.customer.CustomerIdCountByContractIdReport;
import com.oracle.exercise.reports.customer.CustomerIdByGeoZoneReport;
import com.oracle.exercise.reports.customer.CustomerIdCountByGeoZoneReport;

/**
 * Enum for all of the customer reports, based on the entry in the enum all reports are registered in the factory
 */
public enum CustomerReports {
    AverageBuildDurationByGeoZone("AverageBuildDurationByGeoZone", new AverageBuildDurationByGeoZone()),
    CustomerIdByCountContractIdReport("CustomerIdByCountContractIdReport", new CustomerIdCountByContractIdReport()),
    CustomerIdByGeoZoneReport("CustomerIdByGeoZoneReport", new CustomerIdByGeoZoneReport()),
    CustomerIdCountByGeoZoneReport("CustomerIdCountByGeoZoneReport", new CustomerIdCountByGeoZoneReport());

    CustomerReports(String reportName, Report report){
        this.reportName = reportName;
        this.report = report;
    }

    /**
     * name of report generator
     */
    private String reportName;
    /**
     * instance of report generator
     */
    private Report<Customer> report;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Report<Customer> getReport() {
        return report;
    }

    public void setReport(Report<Customer> report) {
        this.report = report;
    }
}
