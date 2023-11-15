package com.solvd.carina.demo.taskTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.ios.*;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;

public class Task2Tests implements IAbstractTest, IMobileUtils {

    @Test
    public void userLoginHappyPath(){
        HomePage homePage = new HomePage(getDriver());
        LoginSwagPage loginSwagPage = homePage.openSwag();
        loginSwagPage.login();
    }

    @Test
    public void addItemToCartHappyPath(){
        HomePage homePage = new HomePage(getDriver());
        LoginSwagPage loginSwagPage = homePage.openSwag();
        WelcomePage welcomePage = loginSwagPage.login();
        welcomePage.addRandomItemToCart();
        welcomePage.checkItemIsAddedToCart();
    }

    @Test
    public void userLoginWrongCredentialsFail(){
        HomePage homePage = new HomePage(getDriver());
        LoginSwagPage loginSwagPage = homePage.openSwag();
        loginSwagPage.loginRandomCredentials();
    }

    @Test
    public void removeItemFromCartHappyPath(){
        HomePage homePage = new HomePage(getDriver());
        LoginSwagPage loginSwagPage = homePage.openSwag();
        WelcomePage welcomePage = loginSwagPage.login();
        welcomePage.addRandomItemToCart();
        CartPage cartPage= welcomePage.checkItemIsAddedToCart();
        cartPage.removeItemFromCart();
        cartPage.assertItemIsNotInCart();
    }

    @Test
    public void userAbleToLogoutHappyPath(){
        HomePage homePage = new HomePage(getDriver());
        LoginSwagPage loginSwagPage = homePage.openSwag();
        WelcomePage welcomePage = loginSwagPage.login();
        MenuPage menuPage = welcomePage.openMenu();
        menuPage.assertMenuPageIsOpened();
        menuPage.logout();
        loginSwagPage.assertLoginPageOpen();
    }
}
