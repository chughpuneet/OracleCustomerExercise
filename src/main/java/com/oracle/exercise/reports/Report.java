package com.oracle.exercise.reports;

import java.util.List;

/**
 * Interface of report generator
 * @param <T> type parameter of the object to generate the report
 */
public interface Report<T> {
    public void generateReport(List<T> collection);
}
