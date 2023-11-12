package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeIcon[@name='Files']")
    private ExtendedWebElement filesElement;

    @FindBy(xpath = "//XCUIElementTypeIcon[@name='Calendar']")
    private ExtendedWebElement calendarElement;

    public FilesPage openFiles(){
        filesElement.click();
        return new FilesPage(driver);
    }

    public CalendarPage openCalendar(){
        calendarElement.click();
        return new CalendarPage(driver);
    }
}
