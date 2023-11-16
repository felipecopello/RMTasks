package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomeIOSPage extends HomePageBase {

    @FindBy(xpath = "//XCUIElementTypeIcon[@name='SwagLabsMobileApp']")
    private ExtendedWebElement swagElement;

    public HomeIOSPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginSwagIOSPage openSwag(){
        swagElement.click();
        return new LoginSwagIOSPage(driver);
    }
}
