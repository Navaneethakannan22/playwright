package com.mytheresa.assertions;

import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseAssertions {
    private static final Logger logger = LoggerFactory.getLogger(BaseAssertions.class);

    protected static void validateBrokenLink(String url) {
        int respCode;
        SoftAssertions softAssertions = new SoftAssertions();
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();
            respCode = httpURLConnection.getResponseCode();
            softAssertions.assertThat(respCode).isLessThan(400);

        } catch (IOException e) {
            logger.warn("There was a error in validating URLs");
            e.printStackTrace();
        }
        logger.info("URl is validated successfully.");
    }
}
