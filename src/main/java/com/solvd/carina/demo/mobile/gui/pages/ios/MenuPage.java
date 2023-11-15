package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuPage extends AbstractPage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-LOGOUT']")
    private ExtendedWebElement logoutButton;

    public void logout(){
        logoutButton.click();
    }

    public void assertMenuPageIsOpened(){
        Assert.assertTrue(logoutButton.isElementPresent(),"menu page is not opened");
    }
}
