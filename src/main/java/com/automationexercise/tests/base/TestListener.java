package com.automationexercise.tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private Logger log;
    private String testName;
    private String testMethodName;

    @Override
    public void onStart(ITestContext context) {
        this.testName = context.getCurrentXmlTest().getName();
        this.log = LogManager.getLogger(testName);
        log.info("[TEST " + testName + " STARTED]");
    }

    @Override
    public void onTestStart(ITestResult result) {
        testMethodName = result.getMethod().getMethodName();
        log.info("[Starting " + testMethodName + "]");
        ExtentTest extentTest = extent.createTest(testMethodName);
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
        log.info("[Test " + testMethodName + " passed]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("[Test " + testMethodName + " failed]");

        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        Throwable throwable = result.getThrowable();

        test.get().fail(throwable);  // Stacktrace completo en el HTML

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, testMethodName);

        test.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
        log.info("[Test " + testMethodName + " skipped]");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("[ALL " + testName + " FINISHED]");
        extent.flush();
    }
}