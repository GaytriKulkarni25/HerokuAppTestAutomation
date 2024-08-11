package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

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

        //Assert.assertEquals(!(deleteButton.isDisplayed()),false);
         List<WebElement> delButtons=  driver.findElements(By.xpath("//div[@id='elements']/button"));
         if(delButtons.size()>0)
             System.out.println("delete button size"+ delButtons.size());
         else
             System.out.println("delete button  not found"+ delButtons.size());
        deleteButton.click();
       

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }


}
