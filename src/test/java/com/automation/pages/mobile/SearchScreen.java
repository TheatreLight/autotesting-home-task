package com.automation.pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchScreen extends BaseScreen {

    private final By searchInput = By.id("org.wikipedia:id/search_src_text");
    private final By searchResults = By.id("org.wikipedia:id/page_list_item_title");
    private final By searchResultsContainer = By.id("org.wikipedia:id/search_results_list");
    private final By searchCloseButton = By.id("org.wikipedia:id/search_close_btn");
    private final By searchBackButton = By.className("android.widget.ImageButton");
    private final By noResultsText = By.id("org.wikipedia:id/results_text");

    public SearchScreen(AndroidDriver driver) {
        super(driver);
    }

    public void enterSearchText(String text) {
        type(searchInput, text);
    }

    public boolean hasSearchResults() {
        try {
            return isElementDisplayed(searchResultsContainer);
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getSearchResults() {
        return findElements(searchResults);
    }

    public int getSearchResultsCount() {
        try {
            return getSearchResults().size();
        } catch (Exception e) {
            return 0;
        }
    }

    public ArticleScreen tapFirstResult() {
        List<WebElement> results = getSearchResults();
        if (!results.isEmpty()) {
            results.get(0).click();
        }
        return new ArticleScreen(driver);
    }

    public ArticleScreen tapResultByIndex(int index) {
        List<WebElement> results = getSearchResults();
        if (index < results.size()) {
            results.get(index).click();
        }
        return new ArticleScreen(driver);
    }

    public String getFirstResultTitle() {
        List<WebElement> results = getSearchResults();
        if (!results.isEmpty()) {
            return results.get(0).getText();
        }
        return "";
    }

    public void clearSearch() {
        click(searchCloseButton);
    }

    public MainScreen goBack() {
        click(searchBackButton);
        return new MainScreen(driver);
    }
}
