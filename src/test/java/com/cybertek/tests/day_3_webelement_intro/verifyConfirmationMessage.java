package com.cybertek.tests.day_3_webelement_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyConfirmationMessage {
    public static void main(String[] args) {

        /*
        verify confirmation message
        open Browser
        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        enter any email
        verify that email is displayed in the input box
        click on retrieve password
        verify that confirmation message says "yor e-mail's been sent!"
         */

        //open Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement email = driver.findElement(By.name("email"));
      String expectedemail = "kadir@gmail.com"; // bunu da asagiya kullanabiliriz
        email.sendKeys(expectedemail);

        //somehow we should get tezt form web elements
        //two main way to get txt from web elements
        //1.getText() --> it will work %99 and it will return string
        //2.getAttribute("Value") --> second way of getting text especially input boxes

        String actualemail = email.getAttribute("value");
        System.out.println("actualemail = " + actualemail);

        //verify that email is displayed in the input box
        if(expectedemail.equals(actualemail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //click on retrieve password
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        //verify that confirmation messaje says "your e-mail's been sent"
        WebElement actualconfirmationmessage = driver.findElement(By.name("confirmation_message"));
        System.out.println(actualconfirmationmessage.getText());

        //save expected message
        String expectedmessage = "Your e-mail's been sent!";
        //save actual message
        String actualmessage = actualconfirmationmessage.getText();

        if (expectedmessage.equals(actualmessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualmessage = " + actualmessage);
            System.out.println("expectedmessage = " + expectedmessage);

        }

    }
}
