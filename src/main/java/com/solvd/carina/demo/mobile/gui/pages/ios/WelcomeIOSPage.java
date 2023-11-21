package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomeIOSPage extends WelcomePageBase {

    @ExtendedFindBy(iosPredicate = "name='test-Cart'")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name='1'")
    private ExtendedWebElement oneItemTag;

    @ExtendedFindBy(iosPredicate = "name='test-Menu'")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-ADD TO CART'][%d])")
    private ExtendedWebElement addToCartButton;

    public WelcomeIOSPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(addToCartButton);
    }

    @Override
    public boolean isOneItemTagPresent() {
        return oneItemTag.isElementPresent();
    }

    @Override
    public CartPageBase clickAddToCartButton(int index) {
        addToCartButton.format(index).click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMenuButton() {
        menuButton.click();
        return initPage(getDriver(), MenuPageBase.class);
    }

}
