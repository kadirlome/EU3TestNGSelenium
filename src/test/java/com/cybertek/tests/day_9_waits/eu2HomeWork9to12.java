package com.cybertek.tests.day_9_waits;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class eu2HomeWork9to12 {
    WebDriver driver;

    @BeforeMethod
    public void set() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();

    }
    @AfterMethod
    public void quit() {
        driver.quit();
    }
/**
 * Test case #9
 * Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
 * Step 2. And click on “Status Codes”.
 * Step 3. Then click on “200”.
 * Step 4. Verify that following message is displayed: “This page returned a
 200 status code”
 */
    @Test
    public void Tcase9(){

        driver.findElement(By.xpath("//a[.='200']")).click();
        WebElement displayed=driver.findElement(By.tagName("p"));
        Assert.assertTrue(displayed.isDisplayed());
        System.out.println(displayed.getText());
        /** veya
         * boolean contains = displayed.contains("This page returned a 200 status code");
         * Assert.assertTrue(contains);
         */

    }
    @Test
    public void Tcase10(){

        driver.findElement(By.linkText("301")).click();
        String displayed = driver.findElement(By.tagName("p")).getText();
        boolean contains = displayed.contains("This page returned a 301 status code");
        Assert.assertTrue(contains);

    }
    @Test
    public void Tcase11(){
        driver.findElement(By.xpath("//li[.='404']")).click();
        WebElement displayed =driver.findElement(By.tagName("p"));
        Assert.assertTrue(displayed.isDisplayed());

    }
    @Test
    public void Tcase12(){
        driver.findElement(By.linkText("500"));
        String displayed = driver.findElement(By.tagName("p")).getText();
        boolean contains = displayed.contains("This page returned a  404 status code");
        Assert.assertTrue(contains);
    }
}
