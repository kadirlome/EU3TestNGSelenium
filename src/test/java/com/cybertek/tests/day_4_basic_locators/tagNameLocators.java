package com.cybertek.tests.day_4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize the window
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.tagName("input"));
        fullnameInput.sendKeys("kadir celik");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("kadir@gmail.com");


       driver.findElement(By.tagName("button")).click();
       Thread.sleep(3000);

       driver.quit();
    }
}
