package com.cybertek.tests.ExcercisePackage;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTry extends TestBase {


    /**
     * Open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customer -> contacts
     * Click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
    LoginPage loginPage = new LoginPage();

    @Test
    public void Tcase1(){
        extentLogger = reports.createTest("Check again contacts info");

        extentLogger.info("Login as a Driver");
        loginPage.loginAsDriver();

        extentLogger.info("Navigate to Customer to contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");

        Contacts contacts = new Contacts();

        extentLogger.info("Find the e amil and click");
        BrowserUtils.waitFor(3);
        contacts.getContactEmail("dragana.ivanovic@gmail.com").click();

        ContactsInfo contactsInfo = new ContactsInfo();

        extentLogger.info("Chech the name same or not");
        Assert.assertEquals(contactsInfo.fullname.getText(),"Dragana Ivanovic","Verify the name");

        extentLogger.info("Check email adress same or not");
        Assert.assertEquals(contactsInfo.email.getText(),"dragana.ivanovic@gmail.com","Chechk email");

        extentLogger.info("Check the phone number ");
        Assert.assertEquals(contactsInfo.phone.getText(),"602-512-963","Chechk phone number ");
        extentLogger.pass("Passed");
    }

    @Test
    public void Tcase2(){

        /**
         * Open the chrome
         * go to qa1.vytrack
         * login as a sales manager
         * navigate to customer -> contacts
         * Click on email dragana.ivanovic@gmail.com
         * verify that full name is Dragana Ivanovic
         * verify that email is dragana.ivanovic@gmail.com
         * verify that phone number is 602-512-963
         * click on Add Address
         * Send some information for First name
         * Sent some information for Last Name
         * Select country "Alabama"
         * Sent some information to city "Somerset"
         * close browser
         */
        extentLogger=reports.createTest("Add adress");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("'Login as Store manager");
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Naviget to customer-->contacs");
        dashboardPage.navigateToModule("Customers","Contacts");

        BrowserUtils.waitFor(3);

        Contacts contacts = new Contacts();
        contacts.getContactEmail("dragana.ivanovic@gmail.com").click();

        ContactsInfo contactsInfo = new ContactsInfo();
        Assert.assertEquals(contactsInfo.fullname.getText(),"Dragana Ivanovic");

        Assert.assertEquals(contactsInfo.email.getText(),"dragana.ivanovic@gmail.com");

        Assert.assertEquals(contactsInfo.phone.getText(),"602-512-963");

        contactsInfo.addAdress.click();
        BrowserUtils.waitFor(3);

        AddAdress addAdress = new AddAdress();
        addAdress.label.sendKeys("kadirrr");
        addAdress.FirstName.sendKeys("Kadir");
        addAdress.lastName.sendKeys("Celik");
        addAdress.save.click();
        extentLogger.pass("Passed");


    }
}
