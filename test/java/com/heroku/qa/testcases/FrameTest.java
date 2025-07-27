package com.heroku.qa.testcases;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.pages.WebElementDemo;
import com.heroku.qa.pages.framePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends TestBase {

  framePage elePage;
    public FrameTest() {
        super();
    }


    @BeforeTest
    public void setup()
    {
        initialization();
        elePage= new framePage();
    }

    @Test
    public void test1() throws InterruptedException {
         elePage.frameOps();
    }

    @AfterTest
    public void tearDown()
    {
        //driver.quit();
    }

}
