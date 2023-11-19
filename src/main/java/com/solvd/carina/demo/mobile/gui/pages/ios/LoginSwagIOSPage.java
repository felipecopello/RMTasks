package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.github.javafaker.Faker;
import com.solvd.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginSwagPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginSwagPageBase.class)
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

    public LoginSwagIOSPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoginErrorPromptPresent() {
        return loginErrorPrompt.isElementPresent();
    }

    @Override
    public boolean isPassWordInputPresent() {
        return passWordInput.isElementPresent();
    }

    @Override
    public boolean isCartButtonPresent() {
        return cartButton.isElementPresent();
    }

    @Override
    public WelcomePageBase login(){
        userNameInput.type("standard_user");
        passWordInput.type("secret_sauce");
        loginButton.click();
        return initPage(getDriver(), WelcomePageBase.class);
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
