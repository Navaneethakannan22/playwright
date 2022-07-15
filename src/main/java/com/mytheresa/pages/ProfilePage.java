package com.mytheresa.pages;

public class ProfilePage extends BasePage{
    String myOverview="text=MY OVERVIEW";

    public boolean IsMyOverviewDisplayed() {
        return isElementVisible(myOverview);
    }
}
