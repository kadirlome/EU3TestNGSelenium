package com.cybertek.tests.day_9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver;

    @BeforeMethod
    public void methodsetUp(){

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames
        //1.switch using byName or Id attrbute of iframe
        driver.switchTo().frame("mce_0_ifr");
        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("");

        //goes back to first frame(main HTML)
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.Switching with index
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Kadir and kadir");

        //second way to switch parent
        driver.switchTo().parentFrame(); // if we have more than one html, we use this for going parent html

        //3.USING WEBELEMENT
        //Locating iframe with any valid locator
        WebElement iframewebelement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframewebelement);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike and Smith ");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switch to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frame under left middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //goes back to top frame
        driver.switchTo().parentFrame();

        //switching right with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
