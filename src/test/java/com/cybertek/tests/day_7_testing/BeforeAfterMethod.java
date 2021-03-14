package com.cybertek.tests.day_7_testing;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before the class one time ");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After Class one time ");
    }

    @Ignore
    @Test
    public void facebookTest(){
        System.out.println("First test Case");
        WebDriver driver = WebDriverFactory.getDriver("chorme");
    }

    @Test
    public void amazontest(){
        System.out.println("amazon test case");
    }


    @BeforeMethod // it will run before every test case
    public void before(){
        System.out.println("browser");
    }

    @AfterMethod // it will be run after every case
    public void after(){
        System.out.println("browser,quit");
    }
}
