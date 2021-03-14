package com.cybertek.tests.day_5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW2_case {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http:/practice.cybertekschool.com/forgot_password");
        WebElement home = driver.findElement(By.xpath("//li[@*='Home'[1]"));
        home.click();
    }
}
