package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartIOSPage extends CartPageBase {

    @ExtendedFindBy(iosPredicate = "name='REMOVE'")
    private ExtendedWebElement removeButton;

    @ExtendedFindBy(iosPredicate = "name='1'")
    private ExtendedWebElement oneItemTag;

    public CartIOSPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(removeButton);
    }

    @Override
    public boolean isOneItemTagPresent() {
        return oneItemTag.isElementPresent();
    }

    @Override
    public void removeItemFromCart(int orderInList) {
        removeButton.format(orderInList).click();
    }
}
