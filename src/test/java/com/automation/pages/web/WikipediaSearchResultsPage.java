package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WikipediaSearchResultsPage extends BasePage {

    private final By searchResults = By.cssSelector(".mw-search-result-heading a");
    private final By searchResultsContainer = By.cssSelector(".mw-search-results");
    private final By noResultsMessage = By.cssSelector(".mw-search-nonefound");
    private final By articleTitle = By.id("firstHeading");
    private final By articleContent = By.id("mw-content-text");

    public WikipediaSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasSearchResults() {
        try {
            return isElementDisplayed(searchResultsContainer);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasNoResultsMessage() {
        try {
            return isElementDisplayed(noResultsMessage);
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getSearchResults() {
        return findElements(searchResults);
    }

    public int getSearchResultsCount() {
        return getSearchResults().size();
    }

    public void clickFirstResult() {
        List<WebElement> results = getSearchResults();
        if (!results.isEmpty()) {
            results.get(0).click();
        }
    }

    public String getArticleTitle() {
        return getText(articleTitle);
    }

    public boolean isArticleContentDisplayed() {
        return isElementDisplayed(articleContent);
    }

    public boolean isOnArticlePage() {
        return getCurrentUrl().contains("/wiki/");
    }
}
