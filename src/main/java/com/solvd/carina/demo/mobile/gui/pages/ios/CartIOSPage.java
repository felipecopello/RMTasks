package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartIOSPage extends CartPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='REMOVE']")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='%d']")
    private ExtendedWebElement oneItemTag;

    public CartIOSPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOneItemTagPresent() {
        return oneItemTag.isElementPresent();
    }

    @Override
    public void removeItemFromCart(Integer orderInList){
        removeButton.format(orderInList).click();
    }
}
