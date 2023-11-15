package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.github.javafaker.Faker;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginSwagPage extends AbstractPage {
    public LoginSwagPage(WebDriver driver) {
        super(driver);
    }

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

    public WelcomePage login(){
        userNameInput.type("standard_user");
        passWordInput.type("secret_sauce");
        loginButton.click();
        assertUserLoggedIn();
        return new WelcomePage(driver);
    }

    public void assertUserLoggedIn(){
        Assert.assertTrue(cartButton.isElementPresent(), "User is not logged in");
    }

    public void loginRandomCredentials(){

        Faker faker = new Faker();
        String randomUsername = faker.lorem().characters(10);
        String randomPass = faker.lorem().characters(10);

        userNameInput.type(randomUsername);
        passWordInput.type(randomPass);
        loginButton.click();

        Assert.assertTrue(loginErrorPrompt.isElementPresent(),"Loggin error message is not present");
    }

    public void assertLoginPageOpen(){
        Assert.assertTrue(passWordInput.isElementPresent(), "login page is not opened");
    }


}
