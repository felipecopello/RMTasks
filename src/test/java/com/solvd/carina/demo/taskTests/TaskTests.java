package com.solvd.carina.demo.taskTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.ios.CalendarPage;
import com.solvd.carina.demo.mobile.gui.pages.ios.FilesPage;
import com.solvd.carina.demo.mobile.gui.pages.ios.HomePage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;

public class TaskTests implements IAbstractTest, IMobileUtils {

    @Test
    public void createFileTest(){
        HomePage homePage = new HomePage(getDriver());
        FilesPage filesPage = homePage.openFiles();
        filesPage.assertFolderIsEmpty();
        filesPage.createNewFolder("folder1");
    }

    @Test
    public void newCalendarEventTest(){
        HomePage homePage = new HomePage(getDriver());
        CalendarPage calendarPage = homePage.openCalendar();
        calendarPage.addEvent("Testing class");
        calendarPage.assertEventAdded("Testing class");
    }

    @Test
    public void deleteCalendarEventTest(){
        HomePage homePage = new HomePage(getDriver());
        CalendarPage calendarPage = homePage.openCalendar();
        calendarPage.deleteEvent("Testing class");
        calendarPage.assertEventNotPresent("Testing class");
    }
}
