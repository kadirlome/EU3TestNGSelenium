package com.cybertek.tests.day_7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase2 {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkbox =driver.findElement(By.cssSelector("[id='txtAge']"));
        Assert.assertFalse(checkbox.isDisplayed(),"check message is NOT displayed");

        WebElement click = driver.findElement(By.cssSelector("[id='isAgeSelected']"));
        click.click();

        Assert.assertTrue(checkbox.isDisplayed());

        driver.quit();
    }
}

