package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginSwagPageBase extends AbstractPage {
    public LoginSwagPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WelcomePageBase login(String username, String password);

    public abstract void loginRandomCredentials(String randomUsername, String randomPass);

    public abstract boolean isLoginErrorPromptPresent();

    public abstract boolean isPassWordInputPresent();

}
