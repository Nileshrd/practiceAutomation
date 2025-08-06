package com.fotrea.xmr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fotrea.xmr.base.DriverManager;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {
    	
    	 this.driver = DriverManager.getDriver();
    }

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//button[@class='error-button']//*[name()='svg']");
    By UserNamePassNameError = By.xpath("//h3[@data-test='error']");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
    
    public boolean isInvalidLoginMessageDisplayed() {
        return driver.findElement(error).isDisplayed();
    }

    public boolean isUsernameRequiredMsgDisplayed() {
    return driver.findElement(UserNamePassNameError).isDisplayed();
}
    
    public boolean isPasswordRequiredMsgDisplayed() {
        return driver.findElement(UserNamePassNameError).isDisplayed();
    }
    
    public boolean isLoginButtonVisible() {
        return driver.findElement(By.cssSelector("input[data-test='login-button']")).isDisplayed();
    }
    
    
}
