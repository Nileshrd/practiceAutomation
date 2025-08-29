package com.fortrea.xmr.utils;

import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fotrea.xmr.base.BaseTest;
import org.testng.ITestListener;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
    	 String screenshotName = result.getMethod().getMethodName();
         String screenshotPath = ScreenshotUtil.captureScreenshot(screenshotName);
         System.out.println("Captured screenshot for failed test: " + screenshotName);
         test.fail("Test Failed: " + result.getThrowable(),
                 MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
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
