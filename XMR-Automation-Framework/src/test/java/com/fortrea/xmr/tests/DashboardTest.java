package com.fortrea.xmr.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.fortrea.xmr.utils.ExcelUtil;
import com.fotrea.xmr.base.BaseTest;
import com.fotrea.xmr.pages.DashboardPage;
import com.fotrea.xmr.pages.LoginPage;

public class DashboardTest extends BaseTest {
	
	DashboardPage dashboard;

   

    @Test
    public void testDashboardLoad() {
    	LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        String username = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 1, 1);
        String password = ExcelUtil.getCellData("LoginData.xlsx", "Sheet1", 1, 2);
        login.login(username, password);
        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard is not loaded");
    }

    @Test
    public void testSubjectTilePresent() {
    	
        Assert.assertTrue(dashboard.isSubjectProfileTilePresent(), "Subject Profile tile not visible");
    }

    @Test
    public void testSearchFilter() {
        dashboard.searchFilter("Creatinine");
        // Add validation here
    }

    @Test
    public void testOpenGemcitabineReport() {
        dashboard.clickGemcitabineTile();
        // Validate new page loaded or modal opened
    }

    @Test
    public void testAddNewView() {
        dashboard.clickAddNewView();
        // Validate new view popup/modal is shown
    }
}