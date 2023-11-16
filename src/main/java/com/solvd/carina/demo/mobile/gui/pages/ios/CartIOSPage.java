package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartIOSPage extends CartPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='REMOVE']")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='%d']")
    private ExtendedWebElement oneItemTag;

    public ExtendedWebElement getOneItemTag() {
        return oneItemTag;
    }

    public CartIOSPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void removeItemFromCart(Integer orderInList){
        removeButton.format(orderInList).click();
    }
}
