package com.cybertek.tests.day_10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }

    @Test
    public void hoverTest() throws InterruptedException {
        /**
         * hover each image in the webpage
         * verify each name:user text is displayed
         */
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {
            String xpathimg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathimg));
            System.out.println(xpathimg);

            Actions actions= new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textXpath="//h5[.='name: user"+i+"']";
            WebElement text1 =driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(),"verify user "+1+" is dsplayed");

        }



        /** first way check one a one
        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);

        Thread.sleep(2000);
        actions.moveToElement(img1).perform();
        WebElement text1 =driver.findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(text1.isDisplayed(),"verif is it displayed");
         */
    }
}
