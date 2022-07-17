package com.mytheresa.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.mytheresa.utils.PropertyFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;


public class PlaywrightFactory {
    private static final Logger logger = LoggerFactory.getLogger(PlaywrightFactory.class);

    public Page initializeBrowser() {

        String browserName = System.getProperty("browser")==null?PropertyFileReader.getPropertyValue("browser").trim():System.getProperty("browser");
        logger.info("launching" + browserName + " browser...");

        PlaywrightManager.setPlaywright(Playwright.create());

        switch (browserName.toLowerCase()) {
            case "firefox":
                PlaywrightManager.setBrowser(PlaywrightManager.getPlaywright().firefox().launch(new LaunchOptions().setHeadless(false)));
                break;
            case "safari":
                PlaywrightManager.setBrowser(PlaywrightManager.getPlaywright().webkit().launch(new LaunchOptions().setHeadless(false)));
                break;

            default:
                PlaywrightManager.setBrowser(PlaywrightManager.getPlaywright().chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome")));
                break;
        }
        PlaywrightManager.setBrowserContext(PlaywrightManager.getBrowser().newContext(new Browser.NewContextOptions().setScreenSize(1920, 1800)));
        PlaywrightManager.getBrowserContext().setDefaultNavigationTimeout(0);
        PlaywrightManager.setPage(PlaywrightManager.getBrowserContext().newPage());

        String environment = System.getProperty("env")==null?PropertyFileReader.getPropertyValue("env").trim():System.getProperty("env");
        switch (environment.toLowerCase()) {
            case "local":
                PlaywrightManager.getPage().navigate(EnvironmentVariable.LOCAL_ENV);
                break;
            case "qa":
                PlaywrightManager.getPage().navigate(EnvironmentVariable.QA_ENV);
                break;
            case "staging":
                PlaywrightManager.getPage().navigate(EnvironmentVariable.STAGING_ENV);
                break;

            default:
                PlaywrightManager.getPage().navigate(EnvironmentVariable.PRELIVE_ENV);
                break;
        }
        logger.info("Navigated to the Url successfully");
        return PlaywrightManager.getPage();

    }

}
