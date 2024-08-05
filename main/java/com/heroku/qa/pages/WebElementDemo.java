package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;

public class WebElementDemo extends TestBase {

    @FindBy(linkText="Checkboxes")
    WebElement checkboxLink;
    @FindBy(xpath="(//input[@type='checkbox'])[1]")
    WebElement  checkbox1;
    @FindBy(xpath="(//input[@type='checkbox'])[2]")
    WebElement  checkbox2;
    @FindBy(linkText="Dropdown")
    WebElement dropdownLink;
    @FindBy(id="dropdown")
    WebElement dropDown;
    @FindBy(xpath="(//header)[1]")
    WebElement headerTag1;
    @FindBy(xpath="(//header)[2]")
    WebElement headerTag2;
    @FindBy(id="column-a")
    WebElement columnA;
    @FindBy(id="column-b")
    WebElement columnB;
    @FindBy(linkText="Drag and Drop")
    WebElement dragDropLink;

    @FindBy(linkText = "File Upload")
    WebElement fileUploadLink;
    @FindBy(id="file-upload")
    WebElement upload;
    @FindBy(id="file-submit")
    WebElement fileSub;
    @FindBy(tagName = "h3")
    WebElement h3Tag;

    public WebElementDemo()
    {
        PageFactory.initElements(driver, this);
    }

    public void verifyCheckboxes()
    {
        checkboxLink.click();
        TestUtil.implicitWaitForElement(10);
        checkbox1.click();
    }

    public void verifyDropdown()
    {
        dropdownLink.click();
        Select sel= new Select(dropDown);
        sel.selectByVisibleText("Option 1");
        sel.selectByVisibleText("Option 2");
    }

    public void dragAndDrop()
    {
        dragDropLink.click();
        new Actions(driver)
                .dragAndDrop(columnA,columnB)
                .perform();
        Assert.assertEquals(headerTag1.getText(),"B");
        Assert.assertEquals(headerTag2.getText(),"A");
    }

    public void fileUpload()
    {
        fileUploadLink.click();
        File file = new File("./src/main/resources/welcome.txt");
        upload.sendKeys(file.getAbsolutePath());
        fileSub.click();
        Assert.assertEquals("File Uploaded!",h3Tag.getText());

    }

}
