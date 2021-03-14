package com.cybertek.tests.day_5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW_case_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.wikipedia.org");

        WebElement search = driver.findElement(By.id("searchInput"));
        search.sendKeys("selenium webdriver");

        Thread.sleep(2000);

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(2000);

        WebElement software = driver.findElement(By.xpath("//span[@class='searchmatch']"));
        software.click();
        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);

        if(url.endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


        driver.quit();
    }
}
