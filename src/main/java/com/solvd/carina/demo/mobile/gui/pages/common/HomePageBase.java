package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.gui.pages.ios.LoginSwagIOSPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public LoginSwagIOSPage openSwag(){
        return null;
    };
}
