package com.cybertek.tests.day_7_testing;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("title","tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test3(){
        String expectedTitle="cyb";
        String actualTitle="cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
    }

    @Test
    public void test4(){
        String email = "kadir@gmail.com";
        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }


    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }
    @Test
    public void tearDown(){
        System.out.println("close browser");
    }

}
