package com.automation.tests.web;

import com.automation.pages.web.WikipediaHomePage;
import com.automation.pages.web.WikipediaSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WikipediaSearchTest extends BaseWebTest {

    private WikipediaHomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new WikipediaHomePage(driver);
        homePage.open(baseUrl);
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsProvider() {
        return new Object[][] {
            {"Java programming"},
            {"Selenium WebDriver"},
            {"Test automation"}
        };
    }

    @Test(description = "Verify search functionality returns results")
    public void testSearchReturnsResults() {
        WikipediaSearchResultsPage resultsPage = homePage.search("Java programming");

        Assert.assertTrue(resultsPage.isOnArticlePage() || resultsPage.hasSearchResults(),
            "Search should return results or navigate to article");
    }

    @Test(description = "Verify search navigates to article page")
    public void testSearchNavigatesToArticle() {
        WikipediaSearchResultsPage resultsPage = homePage.search("Albert Einstein");

        Assert.assertTrue(resultsPage.isOnArticlePage(),
            "Should navigate to article page for well-known search term");
    }

    @Test(dataProvider = "searchTerms", description = "Verify search works for different terms")
    public void testSearchWithDifferentTerms(String searchTerm) {
        WikipediaSearchResultsPage resultsPage = homePage.search(searchTerm);

        Assert.assertTrue(resultsPage.isOnArticlePage() || resultsPage.hasSearchResults(),
            "Search for '" + searchTerm + "' should return results");
    }

    @Test(description = "Verify article content is displayed after search")
    public void testArticleContentDisplayed() {
        WikipediaSearchResultsPage resultsPage = homePage.search("Python programming language");

        if (resultsPage.isOnArticlePage()) {
            Assert.assertTrue(resultsPage.isArticleContentDisplayed(),
                "Article content should be displayed");
            Assert.assertFalse(resultsPage.getArticleTitle().isEmpty(),
                "Article title should not be empty");
        }
    }
}
