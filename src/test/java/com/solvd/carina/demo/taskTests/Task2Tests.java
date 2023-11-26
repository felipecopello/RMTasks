package com.solvd.carina.demo.taskTests;

import com.github.javafaker.Faker;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginSwagPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Task2Tests implements IAbstractTest, IMobileUtils {

    @Test
    public void userLoginHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
    }

    @Test
    public void addItemToCartHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
        welcomePage.clickAddToCartButton(new Random().nextInt(5) + 1);
        Assert.assertTrue(welcomePage.isOneItemTagPresent(), "Item is not added to tag");
    }

    @Test
    public void userLoginWrongCredentialsFailTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        String randomUsername = new Faker().lorem().characters(10);
        String randomPass = new Faker().lorem().characters(10);
        loginSwagPage.loginRandomCredentials(randomUsername, randomPass);
        Assert.assertTrue(loginSwagPage.isLoginErrorPromptPresent(), "Login error message is not present");
    }

    @Test
    public void removeItemFromCartHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
        CartPageBase cartPage = welcomePage.clickAddToCartButton(new Random().nextInt(5) + 1);
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(welcomePage.isOneItemTagPresent(), "Item is not added to tag");
        cartPage.removeItemFromCart(1);
        Assert.assertFalse(cartPage.isRemoveItemFromCartPresent(), "Item is still present in the cart");
    }

    @Test
    public void userAbleToLogoutHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
        MenuPageBase menuPage = welcomePage.clickMenuButton();
        Assert.assertTrue(menuPage.isPageOpened(), "Menu page is not opened");
        Assert.assertTrue(menuPage.isLogoutButtonPresent(), "Menu page is not opened");
        menuPage.clickLogoutButton();
        Assert.assertTrue(loginSwagPage.isPassWordInputPresent(), "Login swag page is not opened");
    }
}
