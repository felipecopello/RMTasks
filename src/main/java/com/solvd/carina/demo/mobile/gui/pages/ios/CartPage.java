package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(iosPredicate = "name='REMOVE'")
    private List<ExtendedWebElement> removeButtonList;

    @ExtendedFindBy(iosPredicate = "name == 'YOUR CART'")
    private ExtendedWebElement yourCartTag;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement itemInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(yourCartTag);
    }

    @Override
    public boolean isCartEmpty() {
        return cartButton.isElementPresent();
    }

    @Override
    public void clickRemoveItemButton(int orderInList) {
        removeButtonList.get(orderInList).click();
    }

    @Override
    public boolean isItemInCart(String itemName) {
        return itemInCart.format(itemName).isElementPresent();
    }
}
