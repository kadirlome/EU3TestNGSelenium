package com.cybertek.tests.day_13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * open browser
     * login as a driver
     * verify that page subtitle is quick Launchpad
     * Go to Activities -> calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1(){

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","verify subtitle");

    }

}
