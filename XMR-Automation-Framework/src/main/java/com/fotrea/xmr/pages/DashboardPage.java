package com.fotrea.xmr.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(xpath = "//div[@class= 'app_logo']")
    WebElement header;

    @FindBy(xpath = "//div[contains(text(),'Subject Profile')]")
    WebElement subjectProfileTile;

    @FindBy(xpath = "//input[@placeholder='Quick search...']")
    WebElement quickSearchInput;

    @FindBy(xpath = "//div[contains(text(),'ALT')]")
    WebElement altFilterOption;

    @FindBy(xpath = "//div[contains(text(),'7f. Discontinuation of Gemcitabine')]")
    WebElement gemcitabineTile;

    @FindBy(xpath = "//button[contains(text(),'Add New View')]")
    WebElement addNewViewButton;

    // Actions
    public boolean isDashboardLoaded() {
        return header.isDisplayed();
    }

    public boolean isSubjectProfileTilePresent() {
        return subjectProfileTile.isDisplayed();
    }

    public void searchFilter(String filterName) {
        quickSearchInput.sendKeys(filterName);
    }

    public void clickGemcitabineTile() {
        gemcitabineTile.click();
    }

    public void clickAddNewView() {
        addNewViewButton.click();
    }
}
