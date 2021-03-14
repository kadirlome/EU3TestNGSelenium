package com.cybertek.tests.day_9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    WebDriver driver;

    @BeforeMethod
    public void methodsetUp(){

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        Thread.sleep(6000); // this is coming from java so it will wait until 6 second no more or no less

        driver.findElement(By.id("username")).sendKeys("Mike Smith");


    }
}
