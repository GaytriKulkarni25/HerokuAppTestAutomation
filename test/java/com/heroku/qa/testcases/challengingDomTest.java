package com.heroku.qa.testcases;

import com.heroku.qa.base.TestBase;

import com.heroku.qa.pages.challengingDomPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*   What this script does:

        Opens the page.

        Clicks all three top buttons (blue, red, green).

        Extracts and prints table headers.

        Extracts and prints the first row data.

        Clicks Edit on row 2.

        Clicks Delete on row 3.*/

public class challengingDomTest extends TestBase {
    challengingDomPage elePage;
    public challengingDomTest() {
        super();
    }


    @BeforeTest
    public void setup()
    {
        initialization();
        elePage= new challengingDomPage();
    }

    @Test
    public void test1() throws InterruptedException {
        elePage.domOps();
    }

    @AfterTest
    public void tearDown()
    {
        //driver.quit();
    }
}
