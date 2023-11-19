package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.gui.pages.ios.WelcomeIOSPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginSwagPageBase extends AbstractPage {
    public LoginSwagPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WelcomePageBase login();

    public abstract void loginRandomCredentials();

    public abstract boolean isLoginErrorPromptPresent();

    public abstract boolean isPassWordInputPresent();

    public abstract boolean isCartButtonPresent();
}
