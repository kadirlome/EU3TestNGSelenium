package com.cybertek.tests.day_8_types_of_element_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1. Locate your dropDown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create select object by passing that elent as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //getOptions --> returns all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();
        // print size of the options
        System.out.println("options.size() = " + options.size());


        //print options one by one
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
    }



    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1. Locate your dropDown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create select object by passing that elent as a constructor
        Select stateDropdown = new Select(dropdownElement);

        // verify first selection is  Select a State
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption);

        //HOW TO SELECT OPTIONS FROM DROPDOWN ?
        //1.Select using visible text

        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");


        expectedOption ="Virginia";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify first selection");


        //2.Select Using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);
        expectedOption ="Wyoming";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify first selection");

        //3.Select using Value
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");
        expectedOption ="Texas";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify first selection");
    }
}
