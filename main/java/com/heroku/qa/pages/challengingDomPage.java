package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class challengingDomPage extends TestBase {

    @FindBy(linkText = "Challenging DOM")
    WebElement link;
    @FindBy(xpath = "//a[contains(@class, 'button')]")
    WebElement blueButton;
    @FindBy(xpath = "//a[contains(@class, 'button alert')]")
    WebElement redButton;
    @FindBy(xpath = "//a[contains(@class, 'button success')]")
    WebElement greenButton;

    @FindBy(xpath = "//tr[2]/td/a[text()='edit']")
    WebElement edit;
    @FindBy(xpath = "//tr[3]/td/a[text()='delete']")
    WebElement delete;




    public challengingDomPage() {
        PageFactory.initElements(driver, this);
    }
    public void domOps() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        link.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        blueButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        redButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        greenButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        for(int i=1;i<=7;i++)
        {
            WebElement ele=driver.findElement(By.xpath("//th["+i+"]"));
            System.out.println(ele.getText());
        }

        for(int i=1;i<=7;i++)
        {
            WebElement ele=driver.findElement(By.xpath("//tr/td["+i+"]"));
            System.out.println(ele.getText());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        edit.click();
        delete.click();

    }
}
