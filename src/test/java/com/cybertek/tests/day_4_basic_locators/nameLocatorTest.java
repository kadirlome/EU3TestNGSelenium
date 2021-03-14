package com.cybertek.tests.day_4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // make your browser full page
       // driver.manage().window().fullscreen();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement nameandsurname = driver.findElement(By.name("full_name"));
        nameandsurname.sendKeys("Mike Smith");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("kadir@gmail.com");

        WebElement signup = driver.findElement(By.name("wooden_spoon"));
        signup.click();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.quit();


    }
}
