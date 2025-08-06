package com.fortrea.xmr.utils;

import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.fotrea.xmr.base.BaseTest;
import com.fotrea.xmr.base.DriverManager;

import org.testng.ITestListener;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.captureScreenshot(DriverManager.getDriver(), result.getName());
        test.fail("Test Failed: " + result.getName(),
            MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed: " + result.getName());
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped: " + result.getName());
    }
}
