package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuIOSPage extends MenuPageBase {
    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-LOGOUT']")
    private ExtendedWebElement logoutButton;

    public MenuIOSPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getLogoutButton() {
        return logoutButton;
    }

    @Override
    public void logout(){
        logoutButton.click();
    }

}
