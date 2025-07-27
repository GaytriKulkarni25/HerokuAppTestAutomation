package com.heroku.qa.pages;

import com.heroku.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abTestPage extends TestBase {

    @FindBy(linkText = "A/B Testing")
    WebElement pageLink;

    @FindBy(xpath="//h3")
    WebElement header;

    @FindBy(xpath="//h3/following-sibling::*")
    WebElement content;

    public abTestPage() {
        PageFactory.initElements(driver, this);

    }

    public String getABTestText() {
        pageLink.click();
        return header.getText() + content.getText();
    }
}
