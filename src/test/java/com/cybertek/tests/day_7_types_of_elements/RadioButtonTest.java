package com.cybertek.tests.day_7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http:/practice.cybertekschool.com/radio_buttons");

        //locatinfg radio button
        WebElement blueRadio=driver.findElement(By.cssSelector("#blue"));
        WebElement redRadio= driver.findElement(By.id("red"));

        //how to check radio button is selected ?
        //blue --> true
        System.out.println("blueRadio.isSelected() = " + blueRadio.isSelected());
        //red -->false
        System.out.println("redRadio.isSelected() = " + redRadio.isSelected());

        Thread.sleep(2000);

        //verify blue is selected red is not selected

        Assert.assertTrue(blueRadio.isSelected(),"verify that blue is selected");
        Assert.assertFalse(redRadio.isSelected(),"verify that red is NOT selected");

        //clicking red radio button
        redRadio.click();

        //blue --> false
        Assert.assertFalse(blueRadio.isSelected(),"verify that blue is NOT selected");
        //red -->true
        Assert.assertTrue(redRadio.isSelected(),"verify that red is selected");

        Thread.sleep(3000);
        driver.quit();
    }
}
