package com.oracle.exercise.reports.factory;

import com.oracle.exercise.reports.customer.AverageBuildDurationByGeoZone;
import com.oracle.exercise.reports.customer.CustomerIdCountByContractIdReport;
import com.oracle.exercise.reports.customer.CustomerIdByGeoZoneReport;
import com.oracle.exercise.reports.customer.CustomerIdCountByGeoZoneReport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReportFactoryTest {
    @Test
    public void testCustomerIdByCountContractIdReportInstance(){
        Assert.assertTrue(
                ReportFactory.getFactory().getReport(CustomerReports.CustomerIdByCountContractIdReport.getReportName()) instanceof CustomerIdCountByContractIdReport);
    }

    @Test
    public void testAverageBuildDurationByGeoZoneReportInstance(){
        Assert.assertTrue(
                ReportFactory.getFactory().getReport(CustomerReports.AverageBuildDurationByGeoZone.getReportName()) instanceof AverageBuildDurationByGeoZone);
    }

    @Test
    public void testCustomerIdByGeoZoneReportInstance(){
        Assert.assertTrue(
                ReportFactory.getFactory().getReport(CustomerReports.CustomerIdByGeoZoneReport.getReportName()) instanceof CustomerIdByGeoZoneReport);
    }

    @Test
    public void testCustomerIdCountByGeoZoneReportInstance(){
        Assert.assertTrue(
                ReportFactory.getFactory().getReport(CustomerReports.CustomerIdCountByGeoZoneReport.getReportName()) instanceof CustomerIdCountByGeoZoneReport);
    }


}
