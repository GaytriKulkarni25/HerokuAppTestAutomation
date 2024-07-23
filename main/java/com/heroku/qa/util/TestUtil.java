package com.heroku.qa.util;

import com.heroku.qa.base.TestBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 10;

    public static String TEST_DATA_SHEET_PATH = "C:\\Gayatri\\HerokuAppTestAutomation\\src\\main\\java\\com\\heroku\\qa\\testdata\\herokuAppTestData.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        String username="";
        String password="";
        try {
            file = new FileInputStream(TEST_DATA_SHEET_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet("login");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }


        String[] data = new String[5];


        Row row2= sheet.getRow(1);
        Cell cell1=row2.getCell(0);
        Cell cell2=row2.getCell(1);
        username=cell1.getStringCellValue();
        password=cell2.getStringCellValue();
        System.out.println("Username"+username+"password"+password);

        data[0]=username;
        data[1]=password;



        return new String[][]{{username,password}};
    }
}
