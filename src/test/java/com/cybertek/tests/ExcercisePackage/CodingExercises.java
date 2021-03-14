package com.cybertek.tests.ExcercisePackage;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CodingExercises {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void Test1(){
        driver.get("https://www.google.co.in");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Google"));

        String url =driver.getCurrentUrl();
        if(url.contains("co.in")){
            System.out.println("Pass : url has co.in ");
        }else {
            System.out.println("Fail: url dont have co.in"+url);
        }
    }
    @Test
    public void Test2(){
        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void Test3(){
       driver.get("https://www.nextgenerationautomation.com");
    //   Alert allert = driver.switchTo().alert();
       driver.findElement(By.xpath("//span[.='Close']")).click();
    //   allert.dismiss();



    }

}
