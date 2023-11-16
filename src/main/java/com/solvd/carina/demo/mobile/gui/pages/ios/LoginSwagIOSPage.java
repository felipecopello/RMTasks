package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.github.javafaker.Faker;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginSwagPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginSwagIOSPage extends LoginSwagPageBase {

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='test-Username']")
    private ExtendedWebElement userNameInput;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='test-Password']")
    private ExtendedWebElement passWordInput;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-LOGIN']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Username and password do not match any user in this service.']")
    private ExtendedWebElement loginErrorPrompt;

    public ExtendedWebElement getLoginErrorPrompt() {
        return loginErrorPrompt;
    }

    public ExtendedWebElement getPassWordInput() {
        return passWordInput;
    }

    public LoginSwagIOSPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCartButton() {
        return cartButton;
    }

    @Override
    public WelcomeIOSPage login(){
        userNameInput.type("standard_user");
        passWordInput.type("secret_sauce");
        loginButton.click();
        return new WelcomeIOSPage(driver);
    }

    @Override
    public void loginRandomCredentials(){
        Faker faker = new Faker();
        String randomUsername = faker.lorem().characters(10);
        String randomPass = faker.lorem().characters(10);

        userNameInput.type(randomUsername);
        passWordInput.type(randomPass);
        loginButton.click();
    }
}
