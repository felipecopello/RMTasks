package com.solvd.carina.demo.taskTests;

import com.github.javafaker.Faker;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginSwagPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests implements IAbstractTest, IMobileUtils {

    @Test
    public void userLoginHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
    }

    @Test
    public void userAbleToLogoutHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
        MenuPageBase menuPage = welcomePage.clickMenuButton();
        Assert.assertTrue(menuPage.isPageOpened(), "Menu page is not opened");
        Assert.assertTrue(menuPage.isLogoutButtonPresent(), "Menu page is not opened");
        menuPage.clickLogoutButton();
        Assert.assertTrue(loginSwagPage.isPassWordInputPresent(), "Login swag page is not opened");
    }

    @Test
    public void userLoginWrongCredentialsFailTest() {
        LoginSwagPageBase loginSwagPage = initPage(LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        loginSwagPage.login(new Faker().lorem().characters(10), new Faker().lorem().characters(10));
        Assert.assertTrue(loginSwagPage.isLoginErrorPromptPresent(), "Login error message is not present");
    }

}
