package com.mytheresa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;


public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/extent/index.html"); //raised a bug -->5.0.5
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Test Report");
        spark.config().setReportName("Mytheresa Automation Report");
    }

    public static void getInstance() {

        if (Objects.isNull(extent))
            new ExtentReport();
    }

    public static void createTestNode(String testName) {
        ExtendManager.setExtentTest(extent.createTest(testName));

    }

    public static void terminateInstance() {

        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtendManager.unload();
        }
    }

}