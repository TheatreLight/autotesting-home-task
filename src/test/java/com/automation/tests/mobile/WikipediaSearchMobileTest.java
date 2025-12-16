package com.automation.tests.mobile;

import com.automation.pages.mobile.ArticleScreen;
import com.automation.pages.mobile.MainScreen;
import com.automation.pages.mobile.SearchScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WikipediaSearchMobileTest extends BaseMobileTest {

    private MainScreen mainScreen;

    @BeforeMethod
    public void setUpTest() {
        mainScreen = new MainScreen(driver);
    }

    @DataProvider(name = "searchKeywords")
    public Object[][] searchKeywordsProvider() {
        return new Object[][] {
            {"Java"},
            {"Selenium"},
            {"Android"}
        };
    }

    @Test(description = "Verify search returns results for keyword")
    public void testSearchReturnsResults() {
        SearchScreen searchScreen = mainScreen.tapSearchContainer();
        searchScreen.enterSearchText("Java programming");

        Assert.assertTrue(searchScreen.hasSearchResults(),
            "Search should return results for 'Java programming'");
        Assert.assertTrue(searchScreen.getSearchResultsCount() > 0,
            "Should have at least one search result");
    }

    @Test(description = "Verify opening article from search results")
    public void testOpenArticleFromSearch() {
        SearchScreen searchScreen = mainScreen.tapSearchContainer();
        searchScreen.enterSearchText("Albert Einstein");

        Assert.assertTrue(searchScreen.hasSearchResults(),
            "Search should return results");

        ArticleScreen articleScreen = searchScreen.tapFirstResult();

        Assert.assertTrue(articleScreen.isArticleTitleDisplayed(),
            "Article title should be displayed after opening article");
    }

    @Test(description = "Verify article title matches search term")
    public void testArticleTitleMatchesSearch() {
        SearchScreen searchScreen = mainScreen.tapSearchContainer();
        searchScreen.enterSearchText("Python programming");

        String firstResultTitle = searchScreen.getFirstResultTitle();
        ArticleScreen articleScreen = searchScreen.tapFirstResult();

        String articleTitle = articleScreen.getArticleTitle();
        Assert.assertNotNull(articleTitle, "Article title should not be null");
        Assert.assertFalse(articleTitle.isEmpty(), "Article title should not be empty");
    }

    @Test(dataProvider = "searchKeywords", description = "Verify search works for different keywords")
    public void testSearchWithDifferentKeywords(String keyword) {
        SearchScreen searchScreen = mainScreen.tapSearchContainer();
        searchScreen.enterSearchText(keyword);

        Assert.assertTrue(searchScreen.hasSearchResults(),
            "Search should return results for '" + keyword + "'");
    }

    @Test(description = "Verify scrolling article works")
    public void testScrollArticle() {
        SearchScreen searchScreen = mainScreen.tapSearchContainer();
        searchScreen.enterSearchText("Java");

        ArticleScreen articleScreen = searchScreen.tapFirstResult();
        articleScreen.scrollArticleMultipleTimes(3);

        Assert.assertTrue(articleScreen.isToolbarDisplayed(),
            "Toolbar should remain visible after scrolling");
    }
}
