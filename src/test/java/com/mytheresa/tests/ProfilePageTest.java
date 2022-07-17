package com.mytheresa.tests;

import static com.mytheresa.assertions.ProfilePageAssertion.*;
import com.mytheresa.pages.LoginPage;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginIntoApp() {
     verifyMyOverview(loginPage.doLogin().IsMyOverviewDisplayed());
    }
}
