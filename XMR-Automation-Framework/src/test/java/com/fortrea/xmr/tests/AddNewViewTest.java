package com.fortrea.xmr.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fotrea.xmr.base.BaseTest;
import com.fotrea.xmr.pages.AddNewViewPage;

public class AddNewViewTest extends BaseTest {

    @Test
    public void testAddNewViewOpens() {
        AddNewViewPage viewPage = new AddNewViewPage(driver);
        viewPage.openAddNewView();
        Assert.assertTrue(viewPage.getTotalViewCount() > 0, "View list not loaded");
    }

    @Test
    public void testOpenEachView() {
        String[] allViews = {
            "Area plot", "Band chart", "Horizontal bar chart", "Vertical bar chart",
            "Box plot", "Cloudline", "Force layout", "Joint listing", "Domain listing",
            "Pivot table", "Summary table", "Histogram", "HY's law plot", "Line chart",
            "Directed graph", "Sankey diagram", "Pie chart", "Scatter chart",
            "Treemap", "Hierarchical edge", "Chord diagram", "Map", "Kaplan-Meier plot",
            "Notification", "Swimmer plot", "Subject profile", "RECIST Subject", "RECIST Discrepancy"
        };

        AddNewViewPage viewPage = new AddNewViewPage(driver);
        viewPage.openAddNewView();

        for (String view : allViews) {
            try {
                viewPage.openViewByName(view);
                // Add wait/screenshot/validation
                Thread.sleep(2000);
                System.out.println("✅ View opened: " + view);
            } catch (Exception e) {
                System.out.println("❌ Failed to open view: " + view);
            }
        }
    }
}