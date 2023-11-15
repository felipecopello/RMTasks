package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends AbstractPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeOther[@name='REMOVE']")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='1']")
    private ExtendedWebElement oneItemTag;

    public void removeItemFromCart(){
        removeButton.click();
    }

    public void assertItemIsNotInCart(){
        Assert.assertFalse(oneItemTag.isElementPresent(),"item is still present in the cart");
    }
}
