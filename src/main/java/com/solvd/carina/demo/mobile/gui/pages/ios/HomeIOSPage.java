package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginSwagPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomeIOSPage extends HomePageBase {

    @ExtendedFindBy(iosPredicate = "name='SwagLabsMobileApp'")
    private ExtendedWebElement swagElement;

    public HomeIOSPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginSwagPageBase openSwag(){
        swagElement.click();
        return initPage(getDriver(), LoginSwagPageBase.class);
    }
}
