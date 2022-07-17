package com.mytheresa.pages;

import com.microsoft.playwright.ElementHandle;
import com.mytheresa.factory.PlaywrightFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.mytheresa.factory.PlaywrightManager.*;


public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    String allLinks = "//*[contains(@href,'https://www.mytheresa.com/int_en/men')]";

    public List<ElementHandle> getAllLinks() {
        return getPage().querySelectorAll(allLinks);
    }

}
