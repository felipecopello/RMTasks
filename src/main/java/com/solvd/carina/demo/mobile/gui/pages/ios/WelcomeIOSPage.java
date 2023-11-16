package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

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

    public ExtendedWebElement getOneItemTag() {
        return oneItemTag;
    }

    public CartIOSPage addRandomItemToCart(){
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        addToCartButton.format(randomNumber).click();
        return new CartIOSPage(driver);
    }

    public MenuIOSPage openMenu(){
        menuButton.click();
        return new MenuIOSPage(driver);
    }

}
