package com.mytheresa.pages;

import com.microsoft.playwright.ElementHandle;
import com.mytheresa.utils.PropertyFileReader;

import java.util.List;

import static com.mytheresa.factory.PlaywrightManager.*;

public class HomePage extends BasePage {
    String allLinks = "//*[contains(@href,'https://www.mytheresa.com/en-de/men/')]";

    public List<ElementHandle> getAllLinks() {
        return getPage().querySelectorAll(allLinks);
    }

}
