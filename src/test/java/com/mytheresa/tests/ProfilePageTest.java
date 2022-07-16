package com.mytheresa.tests;

import com.mytheresa.pages.LoginPage;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginIntoApp() {
     loginPage.doLogin();
    }
}
