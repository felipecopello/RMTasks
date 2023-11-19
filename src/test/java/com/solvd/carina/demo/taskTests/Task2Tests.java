package com.solvd.carina.demo.taskTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2Tests implements IAbstractTest, IMobileUtils {

    @Test
    public void userLoginHappyPathTest(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        LoginSwagPageBase loginSwagPage = homePage.openSwag();
        loginSwagPage.login();
        Assert.assertTrue(loginSwagPage.isCartButtonPresent(), "User is not logged in");
    }

    @Test
    public void addItemToCartHappyPathTest(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        LoginSwagPageBase loginSwagPage = homePage.openSwag();
        WelcomePageBase welcomePage = loginSwagPage.login();
        welcomePage.addRandomItemToCart();
        Assert.assertTrue(welcomePage.isOneItemTagPresent(),"item is not added to tag");;
    }

    @Test
    public void userLoginWrongCredentialsFailTest(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        LoginSwagPageBase loginSwagPage = homePage.openSwag();
        loginSwagPage.loginRandomCredentials();
        Assert.assertTrue(loginSwagPage.isLoginErrorPromptPresent(),"Loggin error message is not present");
    }

    @Test
    public void removeItemFromCartHappyPathTest(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        LoginSwagPageBase loginSwagPage = homePage.openSwag();
        WelcomePageBase welcomePage = loginSwagPage.login();
        CartPageBase cartPage = welcomePage.addRandomItemToCart();
        Assert.assertTrue(welcomePage.isOneItemTagPresent(),"item is not added to tag");;
        cartPage.removeItemFromCart(1);
        Assert.assertFalse(cartPage.isOneItemTagPresent(),"item is still present in the cart");
    }

    @Test
    public void userAbleToLogoutHappyPathTest(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        LoginSwagPageBase loginSwagPage = homePage.openSwag();
        WelcomePageBase welcomePage = loginSwagPage.login();
        MenuPageBase menuPage = welcomePage.openMenu();
        Assert.assertTrue(menuPage.isLogoutButtonPresent(),"menu page is not opened");
        menuPage.logout();
        Assert.assertTrue(loginSwagPage.isPassWordInputPresent(), "login page is not opened");
    }
}
