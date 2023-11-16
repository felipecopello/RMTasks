package com.solvd.carina.demo.taskTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.ios.*;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2Tests implements IAbstractTest, IMobileUtils {

    @Test
    public void userLoginHappyPathTest(){
        HomeIOSPage homePage = new HomeIOSPage(getDriver());
        LoginSwagIOSPage loginSwagPage = homePage.openSwag();
        loginSwagPage.login();
        Assert.assertTrue(loginSwagPage.getCartButton().isElementPresent(), "User is not logged in");
    }

    @Test
    public void addItemToCartHappyPathTest(){
        HomeIOSPage homePage = new HomeIOSPage(getDriver());
        LoginSwagIOSPage loginSwagPage = homePage.openSwag();
        WelcomeIOSPage welcomePage = loginSwagPage.login();
        welcomePage.addRandomItemToCart();
        Assert.assertTrue(welcomePage.getOneItemTag().isElementPresent(),"item is not added to tag");;
    }

    @Test
    public void userLoginWrongCredentialsFailTest(){
        HomeIOSPage homePage = new HomeIOSPage(getDriver());
        LoginSwagIOSPage loginSwagPage = homePage.openSwag();
        loginSwagPage.loginRandomCredentials();
        Assert.assertTrue(loginSwagPage.getLoginErrorPrompt().isElementPresent(),"Loggin error message is not present");
    }

    @Test
    public void removeItemFromCartHappyPathTest(){
        HomeIOSPage homePage = new HomeIOSPage(getDriver());
        LoginSwagIOSPage loginSwagPage = homePage.openSwag();
        WelcomeIOSPage welcomePage = loginSwagPage.login();
        CartIOSPage cartPage = welcomePage.addRandomItemToCart();
        Assert.assertTrue(welcomePage.getOneItemTag().isElementPresent(),"item is not added to tag");;
        cartPage.removeItemFromCart(1);
        Assert.assertFalse(cartPage.getOneItemTag().isElementPresent(),"item is still present in the cart");
    }

    @Test
    public void userAbleToLogoutHappyPathTest(){
        HomeIOSPage homePage = new HomeIOSPage(getDriver());
        LoginSwagIOSPage loginSwagPage = homePage.openSwag();
        WelcomeIOSPage welcomePage = loginSwagPage.login();
        MenuIOSPage menuPage = welcomePage.openMenu();
        Assert.assertTrue(menuPage.getLogoutButton().isElementPresent(),"menu page is not opened");
        menuPage.logout();
        Assert.assertTrue(loginSwagPage.getPassWordInput().isElementPresent(), "login page is not opened");
    }
}
