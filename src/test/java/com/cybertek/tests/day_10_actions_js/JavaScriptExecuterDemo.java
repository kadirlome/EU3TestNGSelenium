package com.cybertek.tests.day_10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuterDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }
    @Test
    public void clickWithJS(){

        // how we can clcik somewhere with JavaScript
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",dropdownLink);
    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //how we can type disabled inputBox with JavaScript
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text = "Hello input Box ";
        jse.executeScript("arguments[0].setAttribute('value','"+text+"')",inputBox);
        Thread.sleep(2000);
    }
    @Test
    public void ScrolDownAndUp() throws InterruptedException {

        // how we can scroll the page up or down with Java Script
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

    }

    @Test
    public void scrollToElement(){
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",eng);


    }
}