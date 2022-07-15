package com.mytheresa.tests;

import com.microsoft.playwright.Page;
import com.mytheresa.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    PlaywrightFactory playwrightFactory;
    Page page;


    @BeforeTest
    public void setup() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initializeBrowser();
    }


    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }

}
