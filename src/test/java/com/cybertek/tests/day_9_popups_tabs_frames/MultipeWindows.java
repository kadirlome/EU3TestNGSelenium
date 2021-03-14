package com.cybertek.tests.day_9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipeWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void SwitchWindowsTest() {

        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Title before new Window: "+driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("title after new Window: "+driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String Handel : windowHandles) {
            if(!Handel.equals(currentWindowHandle)){
                driver.switchTo().window(Handel);
            }
        }

        System.out.println("title after  switch new Window: " + driver.getTitle());


    }

    @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before Switch : "+driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        //loop throw each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);

            //whenever your title equals to your expected without title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }

        System.out.println("After Switch " + driver.getTitle());


    }
}
