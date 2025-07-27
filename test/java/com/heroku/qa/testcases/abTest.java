package com.heroku.qa.testcases;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.pages.abTestPage;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class abTest extends TestBase {

    public abTest() {
        super();
    }

    abTestPage page;

    @BeforeTest
    public void setUp() {
        initialization();
        page= new abTestPage();
    }


    @Test
    public void test1()
    {
       System.out.println(page.getABTestText());
    }

    @AfterTest
    public void TearDown()
    {
        //driver.close();
    }




}
