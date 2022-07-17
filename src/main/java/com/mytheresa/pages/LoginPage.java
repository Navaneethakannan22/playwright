package com.mytheresa.pages;

import com.mytheresa.factory.PlaywrightFactory;
import com.mytheresa.utils.PropertyFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mytheresa.factory.PlaywrightManager.getPage;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    String myAccount = "id=myaccount";
    String email = "id=email";
    String password = "id=pass";
    String loginButton = "id=send2";

    public ProfilePage doLogin() {
        getPage().locator(myAccount).hover();
        getPage().locator(email).fill(PropertyFileReader.getPropertyValue("username").trim());
        logger.info("Username is entered successfully");
        getPage().locator(password).fill(PropertyFileReader.getPropertyValue("password").trim());
        logger.info("Password is entered successfully");
        getPage().locator(loginButton).click();
        logger.info("Login button is clicked successfully");

        return new ProfilePage();
    }
}
