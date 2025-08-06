package com.fotrea.xmr.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.List;

public class AddNewViewPage {
    WebDriver driver;

    public AddNewViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // "Add New View" button
    @FindBy(xpath = "//button[contains(text(),'Add new view')]")
    WebElement addNewViewBtn;

    // All view tiles (common class or container)
    @FindBy(xpath = "//div[contains(@class, 'chart-tile')]")
    List<WebElement> viewTiles;

    // Get tile by name
    public WebElement getViewTileByName(String name) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]"));
    }

    // Actions
    public void openAddNewView() {
        addNewViewBtn.click();
    }

    public int getTotalViewCount() {
        return viewTiles.size();
    }

    public void openViewByName(String viewName) {
        getViewTileByName(viewName).click();
    }
}