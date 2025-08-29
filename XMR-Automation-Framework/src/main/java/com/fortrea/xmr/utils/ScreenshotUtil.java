package com.fortrea.xmr.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fotrea.xmr.base.WebDriverFactory;

import java.io.File;

public class ScreenshotUtil {

	public static String captureScreenshot(String screenshotName) {
		
		WebDriver driver = WebDriverFactory.getDriver();
		
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(src, new File(dest));
            System.out.println("Screenshot saved at: " + dest);
            
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
        return screenshotName;
    }
}