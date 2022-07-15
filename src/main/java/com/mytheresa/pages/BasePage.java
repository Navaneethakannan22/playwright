package com.mytheresa.pages;

import static com.mytheresa.factory.PlaywrightManager.getPage;

public class BasePage {

    public boolean isElementVisible(String locator) {
        return getPage().locator(locator).isVisible();
    }
}
