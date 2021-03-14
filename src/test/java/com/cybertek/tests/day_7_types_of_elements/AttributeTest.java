package com.cybertek.tests.day_7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http:/practice.cybertekschool.com/radio_buttons");

        WebElement blueradio = driver.findElement(By.id("blue"));
        blueradio.getAttribute("value");

        //get the value of type attribute
        System.out.println(blueradio.getAttribute("type"));

        //get the value of name attribute
        System.out.println("blueradio.getAttribute() = " + blueradio.getAttribute("name"));

        //get the value of checked
        //since checked attribute does not eep any value, it will return true or false based on the condition
        System.out.println(blueradio.getAttribute("checked"));


        //trying to get attribiute that does exist
        //when we use non exist attribute it will return null
        System.out.println("blueradio.getAttribute() = " + blueradio.getAttribute("href"));

        System.out.println("blueradio.getAttribute() = " + blueradio.getAttribute("outerHTML"));

        driver.get("http:/practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("Inner HTML : "+button2.getAttribute("innerHTML"));

        driver.quit();
    }
}
