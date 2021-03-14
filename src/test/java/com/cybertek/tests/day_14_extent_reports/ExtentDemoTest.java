package com.cybertek.tests.day_14_extent_reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class ExtentDemoTest {
    // thisclass is used for starting and bulding reports
    ExtentReports reports;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    // this will define a test, enables adding logs,authors,test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        reports = new ExtentReports();

        //create report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        // attach the html report to report object
        reports.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        reports.setSystemInfo("Environment ","QA");
        reports.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        reports.setSystemInfo("OS",System.getProperty("os.name"));

    }
    @Test
    public void test1(){
        // give name to current test
        extentLogger = reports.createTest("TC123 Login as Driver Test");

        //test steps
        extentLogger.info("Open chrome browser");

        extentLogger.info("Go to this URL");

        extentLogger.info("Enter Driver username password");

        extentLogger.info("Click Login");

        extentLogger.info("verify logged in");

        //pass()--> marks the test case as passed
        extentLogger.pass("TC123 is passsed");
    }

    @AfterMethod
    public void teardown(){
        //this is when the report is actualy created
        reports.flush();
    }
}
