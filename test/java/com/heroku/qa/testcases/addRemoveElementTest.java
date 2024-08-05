package com.heroku.qa.testcases;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.pages.HomePage;
import com.heroku.qa.pages.addRemoveElementPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addRemoveElementTest extends TestBase {

    public addRemoveElementTest(){
        super();
    }

    addRemoveElementPage addRemove;

    @BeforeMethod
    public void setup() {
        initialization();
        addRemove = new addRemoveElementPage();
    }

    @Test
    public void addRemove() {
        addRemove.validateAddRemoveElement();
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}
