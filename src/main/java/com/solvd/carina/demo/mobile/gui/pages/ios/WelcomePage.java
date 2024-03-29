package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @ExtendedFindBy(iosPredicate = "name='test-Cart'")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name='test-Menu'")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(iosPredicate = "name='test-ADD TO CART'[%d]")
    private ExtendedWebElement addToCartButton;


    public WelcomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(addToCartButton);
    }

    @Override
    public boolean isCartEmpty() {
        return cartButton.isElementPresent();
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
