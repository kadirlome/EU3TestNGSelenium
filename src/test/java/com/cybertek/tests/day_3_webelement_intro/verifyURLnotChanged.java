package com.cybertek.tests.day_3_webelement_intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyURLnotChanged {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected url before clicking button
        String expectedurl = driver.getCurrentUrl();

        //Click on retrieve passeord
        WebElement retrievePsswordButton = driver.findElement(By.id("form_submit"));
        retrievePsswordButton.click();

        //save actual url after clicking
        String actualurl = driver.getCurrentUrl();

        //verify that url did not changed
        if(expectedurl.equals(actualurl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //Close your browser
        driver.quit();

    }
}
