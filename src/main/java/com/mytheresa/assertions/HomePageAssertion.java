package com.mytheresa.assertions;

import com.microsoft.playwright.ElementHandle;
import java.util.List;

public class HomePageAssertion extends BaseAssertions {

    public static void validateAllLinksInHomepage(List<ElementHandle> allLinks) {
        String url;

        for (ElementHandle allLink : allLinks) {
            url = allLink.getAttribute("href");
            if (url.contains("www.mytheresa.com")) {
                validateBrokenLink(url);
            }
        }

    }
}
