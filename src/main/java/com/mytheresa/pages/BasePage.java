package com.mytheresa.pages;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mytheresa.factory.PlaywrightManager.getPage;

public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public boolean isElementVisible(String locator) {
        getPage().waitForSelector(locator);
        return getPage().locator(locator).isVisible();
    }
}
