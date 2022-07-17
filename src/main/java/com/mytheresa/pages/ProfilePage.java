package com.mytheresa.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfilePage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(ProfilePage.class);
    String myOverview="text=MY OVERVIEW";

    public boolean IsMyOverviewDisplayed() {
        return isElementVisible(myOverview);
    }
}
