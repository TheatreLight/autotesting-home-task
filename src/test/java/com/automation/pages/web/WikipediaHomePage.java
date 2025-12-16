package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaHomePage extends BasePage {

    private final By searchInput = By.id("searchInput");
    private final By searchButton = By.cssSelector("button[type='submit']");
    private final By englishLink = By.id("js-link-box-en");
    private final By russianLink = By.id("js-link-box-ru");
    private final By germanLink = By.id("js-link-box-de");
    private final By languageLinks = By.cssSelector(".central-featured-lang");
    private final By logoImage = By.cssSelector(".central-featured-logo img");

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        navigateTo(url);
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(logoImage);
    }

    public void enterSearchText(String text) {
        type(searchInput, text);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public WikipediaSearchResultsPage search(String text) {
        enterSearchText(text);
        clickSearchButton();
        return new WikipediaSearchResultsPage(driver);
    }

    public void clickEnglishWikipedia() {
        click(englishLink);
    }

    public void clickRussianWikipedia() {
        click(russianLink);
    }

    public void clickGermanWikipedia() {
        click(germanLink);
    }

    public int getLanguageLinksCount() {
        return findElements(languageLinks).size();
    }

    public boolean isSearchInputDisplayed() {
        return isElementDisplayed(searchInput);
    }
}
