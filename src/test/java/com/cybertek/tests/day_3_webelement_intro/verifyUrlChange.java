package com.cybertek.tests.day_3_webelement_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyUrlChange {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        String currentUrl = driver.getCurrentUrl();

        //enter any email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mike@cybertek.com");
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        Thread.sleep(3000);

        String actualUrl = driver.getCurrentUrl();

        if(currentUrl.equals(actualUrl)){
            System.out.println("NOT CHANGED");
        }else{
            System.out.println("CHANGED");
        }

        System.out.println("currentUrl = " + currentUrl);
        System.out.println("actualUrl  = " + actualUrl);

        driver.quit();
    }
}
