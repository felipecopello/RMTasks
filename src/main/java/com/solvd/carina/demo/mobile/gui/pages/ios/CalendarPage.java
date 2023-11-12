package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.SkipException;

import java.util.logging.Logger;

public class CalendarPage extends AbstractPage {
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Add']")
    private ExtendedWebElement addButton;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='Title']")
    private ExtendedWebElement titleInput;

    @FindBy(xpath ="//XCUIElementTypeButton[@name='Delete Event']")
    private ExtendedWebElement deleteEventButton;

    public void addEvent(String title){
        addButton.click();
        titleInput.type(title);
        addButton.click();
    }

    public void assertEventAdded(String title){
        By dynamicLocator = By.xpath(String.format("//*[@name[contains(., '%s')]]", title));
        ExtendedWebElement event = findExtendedWebElement(dynamicLocator);
        Assert.assertTrue(event.isElementPresent(),"new event is not displayed");
    }

    public void deleteEvent(String title){
        By dynamicLocator = By.xpath(String.format("//*[@name[contains(., '%s')]]", title));
        WebElement event = null;
        event = driver.findElement(dynamicLocator);
        WebElement eventButton = event;
        if (event != null) {
            waitUntil(driver -> {
                return eventButton.isDisplayed();
            },10);
            event.click();
            deleteEventButton.click();
            deleteEventButton.click();
        }
        else {
            throw new SkipException("Skipping this test because there is no event with the provided name");
        }
    }
    public void assertEventNotPresent(String title){
        By dynamicLocator = By.xpath(String.format("//*[@name[contains(., '%s')]]", title));
        ExtendedWebElement event = findExtendedWebElement(dynamicLocator);
        Assert.assertNull(event,"Deleted event is not present");
    }

}
