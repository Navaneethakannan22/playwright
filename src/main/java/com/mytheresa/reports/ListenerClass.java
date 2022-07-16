package com.mytheresa.reports;


import org.testng.*;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.getInstance();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.terminateInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTestNode(result.getName());
        ExtentLogger.pass(result.getName() + " test is started successfully");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " test is passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log(result.getThrowable().getMessage());
        ExtentLogger.fail(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName() + " test is skipped");
    }


}
