package com.automation.pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ArticleScreen extends BaseScreen {

    private final By articleTitle = By.id("org.wikipedia:id/view_page_title_text");
    private final By articleWebView = By.className("android.webkit.WebView");
    private final By articleToolbar = By.id("org.wikipedia:id/page_toolbar");
    private final By backButton = By.className("android.widget.ImageButton");
    private final By saveButton = By.id("org.wikipedia:id/page_save");
    private final By languageButton = By.id("org.wikipedia:id/page_language");
    private final By shareButton = By.id("org.wikipedia:id/page_share");
    private final By tocButton = By.id("org.wikipedia:id/page_toc_button");

    public ArticleScreen(AndroidDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        return getText(articleTitle);
    }

    public boolean isArticleTitleDisplayed() {
        return isElementDisplayed(articleTitle);
    }

    public boolean isArticleWebViewDisplayed() {
        return isElementDisplayed(articleWebView);
    }

    public boolean isToolbarDisplayed() {
        return isElementDisplayed(articleToolbar);
    }

    public void tapSaveButton() {
        click(saveButton);
    }

    public void tapLanguageButton() {
        click(languageButton);
    }

    public void tapShareButton() {
        click(shareButton);
    }

    public void tapTocButton() {
        click(tocButton);
    }

    public void scrollArticle() {
        scrollDown();
    }

    public void scrollArticleMultipleTimes(int times) {
        for (int i = 0; i < times; i++) {
            scrollDown();
            waitForSeconds(1);
        }
    }

    public SearchScreen goBack() {
        click(backButton);
        return new SearchScreen(driver);
    }
}
