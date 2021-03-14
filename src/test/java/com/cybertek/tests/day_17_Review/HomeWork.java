package com.cybertek.tests.day_17_Review;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class HomeWork extends TestBase {

    @Test
    public void Tcase1() {

        extentLogger = reports.createTest("Check Options");

        extentLogger.info("Login As Storemanager");
        extentLogger.info("password UserUser123");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Nvigate to Activities -> Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Get text for Calendar Events page Subtitle");
        String actualSubTitle = calendarEventsPage.checkOption.getText();
        String expectedSubTitle = "Options";

        extentLogger.info("Check actual and expected result");
        Assert.assertEquals(actualSubTitle, expectedSubTitle);
        extentLogger.pass("PASSED");
    }

    @Test
    public void Tcase2() {
        extentLogger = reports.createTest("Number equals 1");

        extentLogger.info("Login as StoreManger");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events page ");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(5);

        extentLogger.info("Get page number");
        String expectedPageNumber = "1";

        String  actual = calendarEventsPage.pageNumber.getText();
        System.out.println("actual: "+actual);
/*
        extentLogger.info("Check the actual and expected result is equals");
        Assert.assertEquals(actual, expectedPageNumber);
        extentLogger.pass("PASSED");

 */
    }

    @Test
    public void Tcase3() {

        extentLogger = reports.createTest("Number equals 1");

        extentLogger.info("Login as StoreManger");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events page ");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(5);

        String expected = "25";
        extentLogger.info("Check the actual and expected result is equals");
        Assert.assertEquals(calendarEventsPage.perPage.getText(), expected);
        extentLogger.pass("PASSED");
    }

    @Test
    public void Tcase4() {
        extentLogger = reports.createTest("Calendar events Info Verification");

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);

        String pageNumber = calendarEventsPage.lastpagenumber.getText(); //Last page number of the list as strinng need to maniplate
        String number = calendarEventsPage.getNumberOfLastPage(pageNumber); //called method to string man.

        calendarEventsPage.pageNumber.sendKeys(number + Keys.ENTER);
        calendarEventsPage.waitUntilLoaderScreenDisappear(); // Not working
        BrowserUtils.waitFor(5);

        int minusRow = calendarEventsPage.getRecordCounter(); // Rows counted on the last page
        System.out.println("minusRow = " + minusRow);

        int result = Integer.parseInt(number) * 25 - minusRow; //total expected calculated recording result
        System.out.println("result = " + result);

        System.out.println("calendarEventsPage.lastRowNumber.getText() = " + calendarEventsPage.lastRowNumber.getText());
        Assert.assertTrue(calendarEventsPage.lastRowNumber.getText().contains(Integer.toString(result)), "Verification");
    }

    @Test
    public void Tcase4_1(){

        extentLogger = reports.createTest("Calendar events Info Verification");

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);

        String pageNumber = calendarEventsPage.lastpagenumber.getText();
        String number = calendarEventsPage.getNumberOfLastPage(pageNumber);
        BrowserUtils.waitFor(5);

        String total = calendarEventsPage.lastRowNumber.getText();
        int total1 = Integer.parseInt(calendarEventsPage.getTotalNumber(total));

        calendarEventsPage.pageNumber.sendKeys(number+Keys.ENTER);
        BrowserUtils.waitFor(5);

        int minusrows = calendarEventsPage.getRecordCounter();
        int  result = Integer.parseInt(number) * 25 - minusrows;

        Assert.assertEquals(result,total1);






    }

    @Test
    public void Tcase5() throws InterruptedException {
        extentLogger = reports.createTest("Number equals 1");

        extentLogger.info("Login as StoreManger");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities -> Calendar Events page ");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Thread.sleep(5000);
        calendarEventsPage.checkbox.click();
        Thread.sleep(3000);

    }

}
