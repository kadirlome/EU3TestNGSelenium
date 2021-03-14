package com.cybertek.tests.day_5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW_case_2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.com");


        WebElement search = driver.findElement(By.id("gh-ac"));
        search.sendKeys("selenium");
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("gh-btn"));
        button.click();

        String title = driver.getTitle();
        if(title.contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();

    }
}
