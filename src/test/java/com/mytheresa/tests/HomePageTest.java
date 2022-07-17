package com.mytheresa.tests;

import com.microsoft.playwright.ElementHandle;
import static com.mytheresa.assertions.HomePageAssertion.*;
import com.mytheresa.pages.HomePage;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void shouldValidateAllLinks() {
        List<ElementHandle> allLinksInHomePage = homePage.getAllLinks();
        validateAllLinksInHomepage(allLinksInHomePage);
    }

}
