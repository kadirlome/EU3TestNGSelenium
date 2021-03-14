package com.cybertek.tests.day_5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    /**
     * Task
     * go to amazon.com
     * search for selenium
     * click search button
     * verify  1 -48 of 304 for "selenium"
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("java");
        Thread.sleep(2000);

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'result for')]"));
        String resulttext = result.getText();
        System.out.println("resulttext = " + resulttext);

        String expectedResult = "1-48 of over 4,000 results for ";

        if(expectedResult.equals(resulttext)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("resulttext = " + resulttext);

        }


        driver.quit();

    }
}
