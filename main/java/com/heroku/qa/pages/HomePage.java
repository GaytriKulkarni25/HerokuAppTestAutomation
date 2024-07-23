package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.util.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.time.Instant;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

    //PageFactory
    @FindBy(linkText = "A/B Testing")
    WebElement abtesting;

    @FindBy(tagName = "h3")
    WebElement tagH3;

    @FindBy(tagName="p")
    WebElement para;

    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

    //initialising page objects
    public HomePage()
    {
        PageFactory.initElements(driver, this);
    }


    //actions
    public void ABTestingLinkVerification()
    {
        abtesting.click();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       String titleText= tagH3.getText();
        Assert.assertEquals(titleText,"A/B Test Variation 1");
    }



    public void basicAuthLogin(String uname, String pwd)
    {
        //basicAuthLink.click();

        String baseUrl=prop.getProperty("url");
        String[] authUrl=baseUrl.split("://");
        String s1=authUrl[0];
        String s2=authUrl[1];

        String finalUrl="";
        finalUrl=s1+"://"+uname+":"+pwd+"@"+s2+"/basic_auth/";

        System.out.println(finalUrl);

        driver.get(finalUrl);
        driver.get("http://the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals("Congratulations! You must have the proper credentials.",para.getText());
    }


}
