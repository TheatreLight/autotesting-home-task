package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WikipediaArticlePage extends BasePage {

    private final By articleTitle = By.id("firstHeading");
    private final By articleContent = By.id("mw-content-text");
    private final By tableOfContents = By.id("toc");
    private final By tocItems = By.cssSelector("#toc li a");
    private final By languageLinks = By.cssSelector("#p-lang li a");
    private final By infoBox = By.cssSelector(".infobox");
    private final By mainContent = By.id("bodyContent");

    public WikipediaArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        return getText(articleTitle);
    }

    public boolean isArticleContentDisplayed() {
        return isElementDisplayed(articleContent);
    }

    public boolean hasTableOfContents() {
        try {
            return isElementDisplayed(tableOfContents);
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getTableOfContentsItems() {
        return findElements(tocItems);
    }

    public void clickTocItem(int index) {
        List<WebElement> items = getTableOfContentsItems();
        if (index < items.size()) {
            items.get(index).click();
        }
    }

    public boolean hasInfoBox() {
        try {
            return isElementDisplayed(infoBox);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasLanguageLinks() {
        try {
            return isElementDisplayed(languageLinks);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMainContentDisplayed() {
        return isElementDisplayed(mainContent);
    }
}
