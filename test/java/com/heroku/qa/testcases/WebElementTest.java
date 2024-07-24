package com.heroku.qa.testcases;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.pages.WebElementDemo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementTest extends TestBase {

    WebElementDemo elePage;

    public WebElementTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        elePage= new WebElementDemo();
    }

    @Test
    public void TestScenarios()
    {
        //verify checkboxes
        elePage.verifyCheckboxes();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
