package com.automation.pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainScreen extends BaseScreen {

    private final By searchContainer = By.id("org.wikipedia:id/search_container");
    private final By moreLikeThisCard = By.id("org.wikipedia:id/view_card_header_title");
    private final By feedView = By.id("org.wikipedia:id/fragment_feed_feed");
    private final By navTabExplore = By.id("org.wikipedia:id/nav_tab_explore");
    private final By navTabSaved = By.id("org.wikipedia:id/nav_tab_reading_lists");
    private final By navTabSearch = By.id("org.wikipedia:id/nav_tab_search");
    private final By navTabEdits = By.id("org.wikipedia:id/nav_tab_edits");
    private final By navTabMore = By.id("org.wikipedia:id/nav_tab_more");

    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSearchContainerDisplayed() {
        return isElementDisplayed(searchContainer);
    }

    public boolean isFeedViewDisplayed() {
        return isElementDisplayed(feedView);
    }

    public SearchScreen tapSearchContainer() {
        click(searchContainer);
        return new SearchScreen(driver);
    }

    public void tapExploreTab() {
        click(navTabExplore);
    }

    public void tapSavedTab() {
        click(navTabSaved);
    }

    public void tapSearchTab() {
        click(navTabSearch);
    }

    public void tapEditsTab() {
        click(navTabEdits);
    }

    public void tapMoreTab() {
        click(navTabMore);
    }

    public boolean isExploreTabDisplayed() {
        return isElementDisplayed(navTabExplore);
    }

    public void scrollFeed() {
        scrollDown();
    }
}
