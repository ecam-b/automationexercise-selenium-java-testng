package com.automationexercise.tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        reporter.config().setReportName("Test Automation Report");
        reporter.config().setDocumentTitle("ExtentReports");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Elian Camilo Angarita");
        extent.setSystemInfo("Company", "herokuapp");
        return extent;
    }
}
