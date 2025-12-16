package com.automation.tests.web;

import com.automation.pages.web.WikipediaHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaHomePageTest extends BaseWebTest {

    private WikipediaHomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new WikipediaHomePage(driver);
        homePage.open(baseUrl);
    }

    @Test(description = "Verify Wikipedia home page loads successfully")
    public void testHomePageLoads() {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Wikipedia logo should be displayed");
        Assert.assertTrue(homePage.isSearchInputDisplayed(), "Search input should be displayed");
    }

    @Test(description = "Verify language links are present on home page")
    public void testLanguageLinksPresent() {
        int languageCount = homePage.getLanguageLinksCount();
        Assert.assertTrue(languageCount >= 5, "At least 5 main language links should be present");
    }

    @Test(description = "Verify navigation to English Wikipedia")
    public void testNavigateToEnglishWikipedia() {
        homePage.clickEnglishWikipedia();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("en.wikipedia.org"),
            "Should navigate to English Wikipedia. Current URL: " + currentUrl);
    }

    @Test(description = "Verify navigation to Russian Wikipedia")
    public void testNavigateToRussianWikipedia() {
        homePage.clickRussianWikipedia();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ru.wikipedia.org"),
            "Should navigate to Russian Wikipedia. Current URL: " + currentUrl);
    }
}
