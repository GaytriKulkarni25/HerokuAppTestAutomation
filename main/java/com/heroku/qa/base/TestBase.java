package com.heroku.qa.base;

import com.heroku.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {


   public  static WebDriver driver;
    public static Properties prop;

    public TestBase()
    {
        try
        {
            prop= new Properties();
            FileInputStream fs= new FileInputStream("C:\\Gayatri\\HerokuAppTestAutomation\\src\\main\\java\\com\\heroku\\qa\\config\\config.properties");
            prop.load(fs);

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization()
    {
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            driver= new ChromeDriver();
                    }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}
