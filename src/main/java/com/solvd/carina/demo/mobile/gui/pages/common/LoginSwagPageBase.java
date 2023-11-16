package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.gui.pages.ios.WelcomeIOSPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LoginSwagPageBase extends AbstractPage {
    public LoginSwagPageBase(WebDriver driver) {
        super(driver);
    }

    public WelcomeIOSPage login(){
        return null;
    }

    public void loginRandomCredentials(){}
}
