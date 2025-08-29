package com.fortrea.xmr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fortrea.xmr.utils.ExcelUtil;
import com.fotrea.xmr.base.BaseTest;
import com.fotrea.xmr.pages.DashboardPage;
import com.fotrea.xmr.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test(priority=1)
    public void loginWithValidCredentials() throws InterruptedException {
       LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        String username = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 1, 1);
        String password = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 1, 2);
        login.login(username, password);
        
        Thread.sleep(5000);
        Assert.assertTrue(dashboard.isDashboardLoaded());
        return;
        
	}
	
	@Test(priority=2)
    public void loginWithInValidCredentials() throws InterruptedException {
       LoginPage login = new LoginPage(driver);
       String username = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 2, 1);
       String password = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 2, 2);
       login.login(username, password);
        
       Thread.sleep(5000);
      Assert.assertTrue(login.isInvalidLoginMessageDisplayed(), "Epic sadface: You can only access '/inventory.html' when you are logged in.");   
            
    } 
	 @Test(priority=4)
	    public void TC_Login_003_blankUsernameOrPassword() {
	        LoginPage login = new LoginPage(driver);
	        login.login("", "");

	        Assert.assertTrue(login.isUsernameRequiredMsgDisplayed(), "Username required message should appear");
	        Assert.assertTrue(login.isPasswordRequiredMsgDisplayed(), "Password required message should appear");
}
	 
	 @Test(priority=3)
	    public void TC_Login_004_passwordRequiredValidation() {
		 LoginPage login = new LoginPage(driver);
	       String username = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 1, 1);
	       String password = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 5, 5);
	       login.login(username, password);
	        

	        Assert.assertTrue(login.isPasswordRequiredMsgDisplayed(), "'Password is required' message should appear");
	    }
	 
	 @Test(priority=5)
	    public void TC_Login_006_sessionExpiryCheck() throws InterruptedException {
		 LoginPage login = new LoginPage(driver);
	       String username = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 1, 1);
	       String password = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 1, 2);
	       login.login(username, password);

	        // Simulate inactivity
	    //    Thread.sleep(1000 * 60 * 1); // 5 minutes
	        driver.navigate().refresh();
	        Assert.assertTrue(login.isLoginButtonVisible(), "Session should expire and redirect to login page");
	    }

	 
	 
}