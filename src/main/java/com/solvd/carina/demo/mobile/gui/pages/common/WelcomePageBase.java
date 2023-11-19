package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.gui.pages.ios.CartIOSPage;
import com.solvd.carina.demo.mobile.gui.pages.ios.MenuIOSPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase addRandomItemToCart();

    public abstract MenuPageBase openMenu();

    public abstract boolean isOneItemTagPresent();
}
