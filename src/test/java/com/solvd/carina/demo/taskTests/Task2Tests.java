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
        loginSwagPage.isPageOpened();
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        welcomePage.isPageOpened();
    }

    @Test
    public void addItemToCartHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        loginSwagPage.isPageOpened();
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        welcomePage.isPageOpened();
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        welcomePage.clickAddToCartButton(randomNumber);
        Assert.assertTrue(welcomePage.isOneItemTagPresent(), "Item is not added to tag");
    }

    @Test
    public void userLoginWrongCredentialsFailTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        loginSwagPage.isPageOpened();

        Faker faker = new Faker();
        String randomUsername = faker.lorem().characters(10);
        String randomPass = faker.lorem().characters(10);

        loginSwagPage.loginRandomCredentials(randomUsername, randomPass);
        Assert.assertTrue(loginSwagPage.isLoginErrorPromptPresent(), "Login error message is not present");
    }

    @Test
    public void removeItemFromCartHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        loginSwagPage.isPageOpened();
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");

        welcomePage.isPageOpened();
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        CartPageBase cartPage = welcomePage.clickAddToCartButton(randomNumber);
        cartPage.isPageOpened();
        Assert.assertTrue(welcomePage.isOneItemTagPresent(), "Item is not added to tag");
        cartPage.removeItemFromCart(1);
        Assert.assertFalse(cartPage.isOneItemTagPresent(), "Item is still present in the cart");
    }

    @Test
    public void userAbleToLogoutHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        loginSwagPage.isPageOpened();
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");

        welcomePage.isPageOpened();
        MenuPageBase menuPage = welcomePage.clickMenuButton();
        menuPage.isPageOpened();
        Assert.assertTrue(menuPage.isLogoutButtonPresent(), "Menu page is not opened");
        menuPage.clickLogoutButton();
        Assert.assertTrue(loginSwagPage.isPassWordInputPresent(), "Login page is not opened");
    }
}
