package com.cybertek.tests.day_7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase3 {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAll = driver.findElement(By.cssSelector("[id='check1']"));
        Assert.assertEquals("Check All","Check All");
        checkAll.click();

        Assert.assertTrue(checkAll.isDisplayed(),"check the box is selected");
        Thread.sleep(3000);


    }
}
