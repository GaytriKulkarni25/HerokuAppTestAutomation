package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class addRemoveElementPage extends TestBase {

    public addRemoveElementPage()
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText="Add/Remove Elements")
    WebElement elementLink;

    @FindBy(xpath="//button[text()='Add Element']")
    WebElement elementButton;

    @FindBy(xpath="//button[text()='Delete']")
    WebElement deleteButton;



    @Test
    public void validateAddRemoveElement()
    {
        elementLink.click();
        elementButton.click();
        deleteButton.click();
        Assert.assertEquals(!(deleteButton.isDisplayed()),false);

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }


}
