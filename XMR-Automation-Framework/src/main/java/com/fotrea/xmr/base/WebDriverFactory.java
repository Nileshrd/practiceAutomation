package com.fotrea.xmr.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @SuppressWarnings("deprecation")
	public static void setDriver(String browser, boolean isRemote, String gridURL) {
        try {
            WebDriver wd = null;

            switch (browser.toLowerCase()) {
                case "chrome":
                    if (isRemote) {
                    	System.out.println("Running on Selenium Grid at: " + gridURL);
                        ChromeOptions chromeOptions = new ChromeOptions();
                        wd = new RemoteWebDriver(new URL(gridURL), chromeOptions);
                    } else {
                        WebDriverManager.chromedriver().setup();
                        wd = new ChromeDriver();
                    }
                    break;

                case "firefox":
                    if (isRemote) {
                    	System.out.println("Running on Selenium Grid at: " + gridURL);
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        wd = new RemoteWebDriver(new URL(gridURL), firefoxOptions);
                    } else {
                        WebDriverManager.firefoxdriver().setup();
                        wd = new FirefoxDriver();
                    }
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }

            wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wd.manage().window().maximize();
            driver.set(wd);

            

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create WebDriver instance");
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}