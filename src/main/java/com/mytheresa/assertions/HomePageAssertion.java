package com.mytheresa.assertions;

import com.microsoft.playwright.ElementHandle;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HomePageAssertion {


    public static void validateAllLinksInHomepage(List<ElementHandle> allLinks) {
        String url;
        int respCode;
        HttpURLConnection httpURLConnection;
        SoftAssertions softAssertions=new SoftAssertions();

        for (ElementHandle allLink : allLinks) {
            url = allLink.getAttribute("href");
            System.out.println(url);
            if (url.contains("www.mytheresa.com")) {
                try {
                    httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                    httpURLConnection.setRequestMethod("HEAD");
                    httpURLConnection.connect();
                    respCode = httpURLConnection.getResponseCode();
                    System.out.println(url);
                    softAssertions.assertThat(respCode).isLessThan(400);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        softAssertions.assertAll();
    }

}
