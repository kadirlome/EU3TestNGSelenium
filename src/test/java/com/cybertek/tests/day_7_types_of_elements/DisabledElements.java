package com.cybertek.tests.day_7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http:/practice.cybertekschool.com/radio_buttons");

        WebElement greenRadio = driver.findElement(By.id("green"));

        // hoe to check any web element is enabled or not ?
        System.out.println("greenRadio.isEnabled() = " + greenRadio.isEnabled());
        Assert.assertFalse(greenRadio.isEnabled(),"verify green radio NOT enabled ( disabled)");

        greenRadio.click();
    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http:/practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.sendKeys("some message");
    }
}
