package com.cybertek.tests.day_11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableExamples {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }

    @Test
    public void printTable() {

        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table1.getText());
        Assert.assertTrue(table1.getText().contains("John"));

    }

    @Test
    public void getAllHeaders() {
        //how many colums we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }


    }

    @Test
    public void printTableSize() {
        //how namy coums we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());

        // number of rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRows.size());

        //number of rows without header( we pregere this)
        List<WebElement> allRowsWithotHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithotHeader.size());

    }

    @Test
    public void getRow() {
        WebElement getRow = driver.findElement(By.xpath("//table[@id='table1']//tr[2]"));
        System.out.println(getRow.getText());

        //get all rows dynamicaly
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i <= numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(i + "-" + row.getText());


        }
    }

    @Test
    public void getAllCellInOneRow() {
        List<WebElement> value = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
        for (WebElement Element : value) {
            System.out.println(Element.getText());
        }
    }
    @Test
    public void getAsingleCellByIndedx(){
        WebElement singleValue= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        System.out.println(singleValue.getText());
    }
    @Test
    public void printAllCellByIndex() {

        int rowNumber = getNumberOfRows();
        int colNumebr = getNumberOfColum();

        for (int i = 1; i <= rowNumber; i++) {

            for (int j = 1; j <= colNumebr; j++) {
                String CellxPath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.println(CellxPath);

                WebElement Cell = driver.findElement(By.xpath(CellxPath));
                System.out.println(Cell.getText());


            }
        }
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

      String firstName= "John";
      String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
      WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }



    private int getNumberOfColum() {
        List<WebElement> colums = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return colums.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRows.size();
    }

}