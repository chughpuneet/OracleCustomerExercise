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
public class CustomerReportsTest {

    @Test
    public void testAverageBuildDurationByGeoZoneReportName(){
        Assert.assertEquals("AverageBuildDurationByGeoZone", CustomerReports.AverageBuildDurationByGeoZone.getReportName());
    }

    @Test
    public void testAverageBuildDurationByGeoZoneReportInstance(){
        Assert.assertTrue(CustomerReports.AverageBuildDurationByGeoZone.getReport() instanceof AverageBuildDurationByGeoZone);
    }

    @Test
    public void testCustomerIdByCountContractIdReportReportName(){
        Assert.assertEquals("CustomerIdByCountContractIdReport", CustomerReports.CustomerIdByCountContractIdReport.getReportName());
    }

    @Test
    public void testCustomerIdByCountContractIdReportInstance(){
        Assert.assertTrue(CustomerReports.CustomerIdByCountContractIdReport.getReport() instanceof CustomerIdCountByContractIdReport);
    }

    @Test
    public void testCustomerIdByGeoZoneReportReportName(){
        Assert.assertEquals("CustomerIdByGeoZoneReport", CustomerReports.CustomerIdByGeoZoneReport.getReportName());
    }

    @Test
    public void testCustomerIdByGeoZoneReportInstance(){
        Assert.assertTrue(CustomerReports.CustomerIdByGeoZoneReport.getReport() instanceof CustomerIdByGeoZoneReport);
    }

    @Test
    public void testCustomerIdCountByGeoZoneReportName(){
        Assert.assertEquals("CustomerIdCountByGeoZoneReport", CustomerReports.CustomerIdCountByGeoZoneReport.getReportName());
    }

    @Test
    public void testCustomerIdCountByGeoZoneReportInstance(){
        Assert.assertTrue(CustomerReports.CustomerIdCountByGeoZoneReport.getReport() instanceof CustomerIdCountByGeoZoneReport);
    }
}
