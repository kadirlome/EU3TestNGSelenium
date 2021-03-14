package com.cybertek.tests.day_7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http:/practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput =driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //Verify username inputbox is not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(),"check the input box is not displayed");

        // find start button and click
        WebElement startbutton = driver.findElement(By.cssSelector("start>button"));

        // wait until elements displayed
        Thread.sleep(5000);
        startbutton.click();

        Assert.assertTrue(usernameInput.isDisplayed(),"verify inputbox is displayed on the screen");



        driver.quit();
    }
}
