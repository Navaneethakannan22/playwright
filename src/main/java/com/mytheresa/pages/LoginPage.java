package com.mytheresa.pages;

import com.mytheresa.utils.PropertyFileReader;

import static com.mytheresa.factory.PlaywrightManager.getPage;

public class LoginPage {
    String myAccount = "id=myaccount";
    String email = "id=email";
    String password = "id=pass";
    String loginButton = "id=send2";

    public ProfilePage doLogin() {
        getPage().locator(myAccount).hover();
        getPage().locator(email).fill(PropertyFileReader.getPropertyValue("username").trim());
        getPage().locator(password).fill(PropertyFileReader.getPropertyValue("password").trim());
        getPage().locator(loginButton).click();

        return new ProfilePage();
    }
}
