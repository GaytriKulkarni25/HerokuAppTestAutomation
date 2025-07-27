package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import com.heroku.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class framePage extends TestBase {

    @FindBy(xpath = "//li[22]")
    WebElement frameLink;

    @FindBy(linkText = "Frames")
    WebElement iframeLink;

    @FindBy(linkText = "Nested Frames")
    WebElement iframeLink2;


    public framePage() {
        PageFactory.initElements(driver, this);
    }

    public void frameOps() throws InterruptedException {

        executeJS(frameLink);
        iframeLink.click();
        TestUtil.implicitWaitForElement(10);
        iframeLink2.click();
        TestUtil.implicitWaitForElement(10);
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        WebElement body1=driver.findElement(By.tagName("body"));
        System.out.println(body1.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement body2=driver.findElement(By.tagName("body"));
        System.out.println(body2.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement body3=driver.findElement(By.tagName("body"));
        System.out.println(body3.getText());

       driver.switchTo().defaultContent();

       // driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-bottom");
        WebElement body4=driver.findElement(By.tagName("body"));
        System.out.println(body4.getText());
        driver.switchTo().defaultContent();


    }
}
