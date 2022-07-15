package com.mytheresa.tests;

import com.mytheresa.pages.LoginPage;
import com.mytheresa.pages.ProfilePage;
import org.testng.annotations.Test;

import static com.mytheresa.assertions.HomePageAssertion.verifyMyOverview;

public class ProfilePageTest extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginIntoApp() {
        verifyMyOverview(loginPage.doLogin()
                .IsMyOverviewDisplayed());
    }
}
