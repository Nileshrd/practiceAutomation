package com.fotrea.xmr.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fotrea.xmr.config.ConfigReader;

public class BaseTest {
	public WebDriver driver;;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    

    @BeforeSuite
    public void setupReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/XMR_Report.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    @Parameters({"browser", "isRemote"})
    public void setUp(@Optional("chrome") String browser, @Optional("false") String isRemote) {

        // Read Grid URL from ConfigReader
        String gridURL = ConfigReader.getProperty("gridURL");
        

        // Initialize driver (local or Selenium Grid)
        WebDriverFactory.setDriver(browser, Boolean.parseBoolean(isRemote), gridURL);
        driver = WebDriverFactory.getDriver();
        String testurl = ConfigReader.getProperty("TestUrl");
        driver.get(testurl);
        
    }
    
  
    
    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
    

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}