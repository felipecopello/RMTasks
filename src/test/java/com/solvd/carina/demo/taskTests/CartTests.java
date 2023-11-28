package com.solvd.carina.demo.taskTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginSwagPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CartTests implements IAbstractTest, IMobileUtils {
    @Test
    public void addItemToCartHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
        welcomePage.clickAddToCartButton(new Random().nextInt(5) + 1);
        Assert.assertTrue(welcomePage.isCartEmpty(), "Item is not added to cart");
    }

    @Test
    public void removeItemFromCartHappyPathTest() {
        LoginSwagPageBase loginSwagPage = initPage(getDriver(), LoginSwagPageBase.class);
        Assert.assertTrue(loginSwagPage.isPageOpened(), "Login swag page is not opened");
        WelcomePageBase welcomePage = loginSwagPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
        CartPageBase cartPage = welcomePage.clickAddToCartButton(new Random().nextInt(5) + 1);
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertFalse(cartPage.isCartEmpty(), "Item added to cart");
        cartPage.clickRemoveItemButton(0);
        Assert.assertTrue(cartPage.isCartEmpty(), "Item is still present in the cart");
    }
}
