package com.herokuapp.theinternet.qa.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BasicTestListener implements ITestListener
{
    private Logger _logger;
    private String _testName;
    private String _testMethodName;

    public void onStart(ITestContext context)
    {
        this._testName = context.getCurrentXmlTest().getName();
        this._logger = LogManager.getLogger(_testName);
        _logger.info(">> START testing suite: " + _testName + " <<");
    }

    public void onFinish(ITestContext context) {
        _logger.info(">> FINISH testing suite: " + _testName + " <<");
    }

    public void onTestStart(ITestResult result)
    {
        this._testMethodName = result.getMethod().getMethodName();
        _logger.info("[ Now testing method: " + _testMethodName + " ]");
    }

    public void onTestSuccess(ITestResult result) {
        _logger.info("{+} PASSED test: " + _testMethodName + " {+}");
    }

    public void onTestFailure(ITestResult result) {
        _logger.info("{-} FAILED test: " + _testMethodName + " {-}");
    }

    public void onTestSkipped(ITestResult result) {
        _logger.info("{~} SKIPPED test: " + _testMethodName + " {~}");
    }

}
