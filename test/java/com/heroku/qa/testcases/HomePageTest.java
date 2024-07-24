package com.heroku.qa.testcases;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.pages.HomePage;
import com.heroku.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage home;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        home = new HomePage();
    }

    @Test
    public void abtestingLink() {
        home.ABTestingLinkVerification();
    }


    //using data provider
    @DataProvider(name="logincredentials")
    public Object[][] credentials()
    {
        return new Object[][]{{"admin","admin"}};
    }

    @Test(dataProvider = "logincredentials")
    public void basicAuthTest (String username, String password)
    {
        home.basicAuthLogin(username,password);

    }


    //using apache poi
    @DataProvider
    public Object[][] getTestData()
    {

        Object[][] data= TestUtil.getTestData("login");
        return data;
    }
    @Test(dataProvider="getTestData")
    public void loginScenarios(String username, String password)
    {
        home.basicAuthLogin(username,password);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
