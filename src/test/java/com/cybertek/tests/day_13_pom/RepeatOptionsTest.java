package com.cybertek.tests.day_13_pom;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;

public class RepeatOptionsTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void VerifyDaysIsSelected() throws InterruptedException {

        /**
         * VERIFY RADIO BUTTONS
         * Open chrome browser
         * Login as Driver
         * GO to Activities --> Calendar Events
         * Click on create calendar Events
         * Click on repeat
         * Verify that repeat every day is checked
         * verify that repeat weekday is not checked
         */

        extentLogger = reports.createTest("Verify days is selected");
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Go to Dashboard");

        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities --> Calendar ");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
       // calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
       // BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on repeat Button");

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Click on Create Calendar Events Page");

        // Verify that repeat every day is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify repeat days is selected");
        extentLogger.info("Check Days is Selected");

        //verify that repeat weekday is not checked
        extentLogger.info("Check Weekday is not Selected");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify that repeat weekday is not checked");

    }
    @Test
    public void test2() throws InterruptedException {
        /**
         * Open browser
         * Login as driver
         * Go to Activities-> Calendar Events
         * Click on create calendar Events button
         * Click on repeat checkbox
         * Verify that repeat options are Daily, weekly,Monthly,yearly(in this order)
         */

        loginPage.loginAsDriver();

        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Thread.sleep(5000);
        calendarEventsPage.createCalendarEvent.click();


        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        //Click on repeat
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdowmn = createCalendarEventsPage.repeatOptionsList();

        //Verify that repeat options are Daily, Weekly,Monthly,yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdowmn.getOptions();

        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());
        }
        //ready method for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList,expectedList,"verify daily weekly montly yearly");

    }
}
