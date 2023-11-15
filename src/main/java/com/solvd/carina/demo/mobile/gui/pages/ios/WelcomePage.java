package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Random;

public class WelcomePage extends AbstractPage {
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='1']")
    private ExtendedWebElement oneItemTag;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Menu']")
    private ExtendedWebElement menuButton;

    public void addRandomItemToCart(){
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;

        By dynamicLocator = By.xpath(String.format("//XCUIElementTypeOther[@name='test-ADD TO CART'])[%d]", randomNumber));
        ExtendedWebElement itemToAdd = findExtendedWebElement(dynamicLocator);
        itemToAdd.click();
    }

    public CartPage checkItemIsAddedToCart(){
        cartButton.click();
        Assert.assertTrue(oneItemTag.isElementPresent(),"item is not added to tag");
        return new CartPage(driver);
    }

    public MenuPage openMenu(){
        menuButton.click();
        return new MenuPage(driver);
    }

}
