package com.mytheresa.pages;

import com.microsoft.playwright.ElementHandle;

import java.util.List;

import static com.mytheresa.factory.PlaywrightManager.*;


public class HomePage extends BasePage {
    String allLinks = "//*[contains(@href,'https://www.mytheresa.com/int_en/men')]";

    public List<ElementHandle> getAllLinks() {
        return getPage().querySelectorAll(allLinks);
    }

}
