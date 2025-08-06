package com.fotrea.xmr.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver createInstance(String browser) {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        // Add other browsers if needed

       
        return driver;
    }
}