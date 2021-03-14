package com.cybertek.tests.day_12_properties_driver_test;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void Test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

    }
    @Test
    public void Test2() throws InterruptedException {
        WebDriver driver = Driver.get();
        Thread.sleep(2000);
        driver.get("https://www.google.com"); // yada Driver.get().get("https://www.google.com") oalrak da kullnabilriiz
    }
    @Test
    public void Test3(){
        WebDriver driver = Driver.get();
        driver.get("htpps://www.amazon.com");
    }
}
