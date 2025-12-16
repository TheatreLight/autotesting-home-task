package com.automation.tests.mobile;

import com.automation.pages.mobile.MainScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaMainScreenTest extends BaseMobileTest {

    private MainScreen mainScreen;

    @BeforeMethod
    public void setUpTest() {
        mainScreen = new MainScreen(driver);
    }

    @Test(description = "Verify main screen displays search container")
    public void testMainScreenDisplaysSearchContainer() {
        Assert.assertTrue(mainScreen.isSearchContainerDisplayed(),
            "Search container should be displayed on main screen");
    }

    @Test(description = "Verify explore tab is displayed")
    public void testExploreTabDisplayed() {
        Assert.assertTrue(mainScreen.isExploreTabDisplayed(),
            "Explore tab should be displayed");
    }

    @Test(description = "Verify feed view is displayed on main screen")
    public void testFeedViewDisplayed() {
        Assert.assertTrue(mainScreen.isFeedViewDisplayed(),
            "Feed view should be displayed on main screen");
    }

    @Test(description = "Verify scrolling feed works")
    public void testScrollFeed() {
        mainScreen.scrollFeed();
        Assert.assertTrue(mainScreen.isFeedViewDisplayed(),
            "Feed should still be visible after scrolling");
    }
}
