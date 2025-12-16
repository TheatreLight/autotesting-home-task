package com.automation.pages.web;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    protected WebElement findElement(By locator) {
        return waitUtils.waitForElementVisible(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return waitUtils.waitForElementsVisible(locator);
    }

    protected void click(By locator) {
        waitUtils.waitForElementClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitUtils.waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitUtils.waitForElementVisible(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return waitUtils.waitForElementVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }
}
