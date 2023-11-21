package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.LoginSwagPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginSwagPageBase.class)
public class LoginSwagIOSPage extends LoginSwagPageBase {

    @ExtendedFindBy(iosPredicate = "name='test-Username'")
    private ExtendedWebElement userNameInput;

    @ExtendedFindBy(iosPredicate = "name='test-Password'")
    private ExtendedWebElement passWordInput;

    @ExtendedFindBy(iosPredicate = "name='test-LOGIN'")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosPredicate = "name='Username and password do not match any user in this service.'")
    private ExtendedWebElement loginErrorPrompt;

    public LoginSwagIOSPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginButton);
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
    public WelcomePageBase login(String username, String password) {
        userNameInput.type(username);
        passWordInput.type(password);
        loginButton.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }

    @Override
    public void loginRandomCredentials(String randomUsername, String randomPass) {
        userNameInput.type(randomUsername);
        passWordInput.type(randomPass);
        loginButton.click();
    }
}
