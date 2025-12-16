package com.automation.tests.mobile;

import com.automation.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseMobileTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(ConfigReader.getProperty("android.platform.name"));
        options.setPlatformVersion(ConfigReader.getProperty("android.platform.version"));
        options.setDeviceName(ConfigReader.getProperty("android.device.name"));
        options.setAutomationName(ConfigReader.getProperty("android.automation.name"));
        options.setAppPackage(ConfigReader.getProperty("android.app.package"));
        options.setAppActivity(ConfigReader.getProperty("android.app.activity"));
        options.setNoReset(ConfigReader.getBooleanProperty("android.no.reset", true));

        String appiumServerUrl = ConfigReader.getProperty("appium.server.url");
        driver = new AndroidDriver(new URL(appiumServerUrl), options);

        int implicitWait = ConfigReader.getIntProperty("timeout.implicit", 10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
