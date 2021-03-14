package com.cybertek.tests.ExcercisePackage;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadiButtons {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement radioBlue= driver.findElement(By.cssSelector("#blue"));
        WebElement radioRed = driver.findElement(By.id("red"));

        Assert.assertTrue(radioBlue.isSelected());
        Assert.assertFalse(radioRed.isSelected());


        driver.quit();

    }



}
