package com.cybertek.tests.day_6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.practice.cybertekschool.com/multiple_buttons");
        WebElement dontclick = driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(dontclick.getText());


        driver.quit();
    }
}
