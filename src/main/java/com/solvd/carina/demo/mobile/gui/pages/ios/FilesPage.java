package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilesPage extends AbstractPage {
    public FilesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Browse' and @value='1']")
    private ExtendedWebElement browseButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='DOC.itemCollectionMenuButton.Ellipsis']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='New Folder']")
    private ExtendedWebElement createNewFolderButton;

    @FindBy(xpath = "//XCUIElementTypeCell[@name='Folder']/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]")
    private ExtendedWebElement folderNameInput;

    @FindBy(id = "On My iPhone is Empty")
    private ExtendedWebElement emptyFolderTextElement;

    @FindBy(id = "On My iPhone")
    private ExtendedWebElement onMyPhoneButton;

    public void goToBrowse(){
        browseButton.click();
        onMyPhoneButton.click();
    }

    public void assertFolderIsEmpty(){
        goToBrowse();
        Assert.isTrue(emptyFolderTextElement.isElementPresent(),"Empty folder text was not present");
    }

    public void openMenu(){
        menuButton.click();
    }

    public void createNewFolder(String folderName){
        openMenu();
        createNewFolderButton.click();
        folderNameInput.type(folderName);
        folderNameInput.sendKeys(Keys.ENTER);
        ExtendedWebElement createdFolder = findExtendedWebElement(By.xpath("//XCUIElementTypeCell[@name='"+folderName+", Folder']"));
        Assert.isTrue(createdFolder.isPresent(),"created folder is not present");
    }
}
