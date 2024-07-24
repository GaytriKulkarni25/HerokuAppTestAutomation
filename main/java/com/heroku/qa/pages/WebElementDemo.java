package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebElementDemo extends TestBase {

    @FindBy(linkText="Checkboxes")
    WebElement checkboxLink;

    @FindBy(xpath="(//input[@type='checkbox'])[2]")
     WebElement  checkbox1;
    @FindBy(xpath="//input[@type='checkbox']")
    WebElement  checkbox2;

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

}
