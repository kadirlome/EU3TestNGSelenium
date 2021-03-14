package com.cybertek.tests.day_15_review;

import com.cybertek.pages.Contacts;
import com.cybertek.pages.ContactsInfo;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void contactDetailsTest(){

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

        extentLogger = reports.createTest("Cheking contacs and email");

        extentLogger.info("Username : salesmanager120");
        extentLogger.info("Password : UserUser123");
        loginPage.loginAsDriver();


        extentLogger.info("Navigate to Customer -> Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");

        Contacts contacts = new Contacts();

        extentLogger.info("Find email and Click ");
        BrowserUtils.waitFor(3);
        contacts.getContactEmail("mbrackstone9@example.com").click();

        ContactsInfo contactsInfo = new ContactsInfo();

        extentLogger.info("Check Fullname");
        String expectedFullname = "Mariam Brackstone";
        String actualFullname=contactsInfo.fullname.getText();

        extentLogger.info("Check name are the same or not");
        Assert.assertEquals(actualFullname,expectedFullname,"Verify full name");

        extentLogger.info("Verify Emails are the same or not");
        Assert.assertEquals(contactsInfo.email.getText(),"mbrackstone9@example.com","verify Email");

        extentLogger.info("Check the Phone Numbers are the same or not");
        Assert.assertEquals(contactsInfo.phone.getText(),"+18982323434","verify Phone Number");
        extentLogger.pass("Passed");

    }
}
