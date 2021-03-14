package com.cybertek.tests.day_14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //name of the test
        extentLogger = reports.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username = user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password = somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong password Test is Passed");
    }


    @Test
    public void wrongUsernameTest(){
        extentLogger = reports.createTest("Wrong Username Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username : someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password :UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.info("Verify page URL");

        extentLogger.pass("Passed");
    }
}
