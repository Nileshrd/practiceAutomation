package com.fotrea.xmr.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fotrea.xmr.config.ConfigReader;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/XMR_Report.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setup() {
        ConfigReader.loadProperties();
        String browser = ConfigReader.get("browser");
        String baseurl = ConfigReader.get("TestUrl");

        WebDriver driver = WebDriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(baseurl);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }

    public void getAlert() {
    	
    	driver.switchTo().alert().accept();
    }
    @AfterMethod
    public void tearDown() {
    	DriverManager.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}