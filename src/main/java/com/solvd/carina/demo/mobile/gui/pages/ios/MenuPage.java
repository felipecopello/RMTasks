package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(iosPredicate = "name='test-LOGOUT'")
    private ExtendedWebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logoutButton);
    }

    @Override
    public boolean isLogoutButtonPresent() {
        return logoutButton.isElementPresent();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

}
