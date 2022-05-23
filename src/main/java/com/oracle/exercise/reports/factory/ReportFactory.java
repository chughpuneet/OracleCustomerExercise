package com.oracle.exercise.reports.factory;

import com.oracle.exercise.reports.Report;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory to get reports
 */
public class ReportFactory {

    private static ReportFactory _this;
    private final Map<String, Report> registeredReports = new HashMap<>();

    private ReportFactory(){
        super();
        Arrays.stream(CustomerReports.values()).forEach(report->{
            registeredReports.put(report.getReportName(), report.getReport());
        });
    }

    public static ReportFactory getFactory(){
        if(null != _this) return _this;

        synchronized (ReportFactory.class){
            _this = new ReportFactory();
            return _this;
        }
    }

    public Report getReport(String reportName){
        if(null == reportName) return null;

        return registeredReports.get(reportName);

    }
}
