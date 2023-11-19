package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomeIOSPage extends WelcomePageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='1']")
    private ExtendedWebElement oneItemTag;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-ADD TO CART'])[%d]")
    private ExtendedWebElement addToCartButton;

    public WelcomeIOSPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOneItemTagPresent() {
        return oneItemTag.isElementPresent();
    }

    @Override
    public CartPageBase addRandomItemToCart(){
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        addToCartButton.format(randomNumber).click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase openMenu(){
        menuButton.click();
        return initPage(getDriver(), MenuPageBase.class);
    }

}
