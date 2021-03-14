package com.cybertek.tests.day_9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class eu2HomeWork1to8 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }

    @Test
    public void Tcase1() throws InterruptedException {

//        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
//        Step 2. Click on “Registration Form”
//        Step 3. Enter “wrong_dob” into date of birth input box.
//        Step 4. Verify that warning message is displayed: “The date of birth is not valid”

        //go to link
        driver.get("http://practice.cybertekschool.com/");

        // find element
        WebElement registration = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        registration.click();
        WebElement wrongdob = driver.findElement(By.xpath("//input[@name='birthday']"));

        //send some keys
        wrongdob.sendKeys("wrong_dob");
        Thread.sleep(2000);

        // check the messaje is diplayed or not
        WebElement displayed = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        System.out.println(displayed.isDisplayed());
    }


    @Test
    public void Tcase2(){


//        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
//        Step 2. Click on “Registration Form”
//        Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript

        driver.get("http://practice.cybertekschool.com/");

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        List<WebElement> options = driver.findElements(By.cssSelector(".form-check-label"));
        Assert.assertEquals(options.get(0).getText(),"C++");
        Assert.assertEquals(options.get(1).getText(),"Java");
        Assert.assertEquals(options.get(2).getText(),"JavaScript");


    }
    @Test
    public void Tcase3(){

//        Test case #3
//        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
//        Step 2. Click on “Registration Form”
//        Step 3. Enter only one alphabetic character into first name input box.
//        Step 4. Verify that warning message is displayed:“first name must be more than 2 and less than 64 characters long”

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.click();
        firstname.sendKeys("a");
        String actualresult = driver.findElement(By.xpath("//small[text()='first name must be " +
                "more than 2 and less than 64 characters long']")).getText();

        String expectedresult = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualresult,expectedresult);
    }


    @Test
    public void Tcase4(){

    /**
     * Test case #4
    * Step 1. Go to https://practice-cybertekschool.herokuapp.com
    * Step 2. Click on “Registration Form”
    * Step 3. Enter only one alphabetic character into last name input box.
    * Step 4. Verify that warning message is displayed: “The last name must be
    more than 2 and less than 64 characters long”
      */
      driver.get("https://practice-cybertekschool.herokuapp.com");
      driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
      WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
      lastname.sendKeys("a");
      String actualresult = driver.findElement(By.xpath("//small[text()='The last name must be more " +
              "than 2 and less than 64 characters long']")).getText();
      String expectedresult = "The last name must be more than 2 and less than 64 characters long";
      Assert.assertEquals(actualresult,expectedresult);
    }

    @Test
    public void Tcase5() throws InterruptedException {
        /**
         * Test case #5
         * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
         * Step 2. Click on “Registration Form”
         * Step 3. Enter any valid first name.
         * Step 4. Enter any valid last name.
         * Step 5. Enter any valid user name.
         * Step 6. Enter any valid password.
         * Step 7. Enter any valid phone number.
         * Step 8. Select gender.
         * Step 9. Enter any valid date of birth.
         * Step 10. Select any department.
         * Step 11. Enter any job title.
         * Step 12. Select java as a programming language.
         * Step 13. Click Sign up.
         * Step 14. Verify that following success message is displayed: “You've
         successfully completed registration!”
         * Note: for using dropdown, please refer to the documentation:
         https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/
         Select.html or,
         * please watch short video about drop-downs that is posted on canvas
         *
         * @throws InterruptedException
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kadir");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("celik");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kamola");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kadir@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("kadir123");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("732-910-8480");
        driver.findElement(By.cssSelector("[value='female']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/08/1998");

        WebElement dropdownElement = driver.findElement(By.cssSelector("[name='department']"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("MPDC");

        WebElement  jobTitle = driver.findElement(By.cssSelector("[name='job_title']"));
        Select job = new Select(jobTitle);
        job.selectByVisibleText("SDET");

        driver.findElement(By.cssSelector("input[value='java']")).click();
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        String actualresult = "You've successfully completed registration!";
        String expectedresult  = driver.findElement(By.xpath("//div/p")).getText();
        System.out.println(expectedresult);

        Assert.assertEquals(expectedresult,actualresult);


        Thread.sleep(5000);
    }

    @Test
    public void Tcase6() throws InterruptedException {
        /**
         * Test case #6
         * Step 1. Go to "https://www.tempmailaddress.com/"
         * Step 2. Copy and save email as a string.
         * Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
         * Step 4. And click on “Sign Up For Mailing List".
         * Step 5. Enter any valid name.
         * Step 6. Enter email from the Step 2.Step
         * 7. Click Sign Up
         * Step 8. Verify that following message is displayed: “Thank you for signing
         up. Click the button below to return to the home page.”
         * Step 9. Navigate back to the “https://www.tempmailaddress.com/”
         * Step 10. Verify that you’ve received an email from “do-notreply@
         practice.cybertekschool.com”
         * Step 11. Click on that email to open it.
         * Step 12. Verify that email is from: “do-notreply@
         practice.cybertekschool.com”
         * Step 13. Verify that subject is: “Thanks for subscribing to
         practice.cybertekschool.com!”
         *
         * @throws InterruptedException
         */

        driver.get("https://www.tempmailaddress.com/");
        String email= driver.findElement(By.cssSelector("span[id='email']")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("mike");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[name='wooden_spoon']")).click();
        Thread.sleep(2000);
        String expectedresult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualresult = driver.findElement(By.cssSelector("[name='signup_message']")).getText();
        Assert.assertEquals(actualresult,expectedresult);

        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);;
        String actualtext = driver.findElement(By.xpath("//*[.='do-not-reply@practice.cybertekschool.com']")).getText();
        Assert.assertFalse(actualtext.contains("do-not-reply@practice.cybertekschool.com"));
        driver.findElement(By.xpath("//div[@id='home']/div/table/tbody/tr[1]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#odesilatel")).getText(),"do-not-reply@practice.cybertekschool.com");
        Assert.assertEquals(driver.findElement(By.cssSelector("#predmet")).getText(),"Thanks for subscribing to practice.cybertekschool.com!");

        Thread.sleep(4000);
    }

    @Test
    public  void Tcase7() throws InterruptedException{
        /**
         * Test case #7
         * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
         * Step 2. And click on “File Upload".
         * Step 3. Upload any file with .txt extension from your computer.
         * Step 4. Click “Upload” button.
         * Step 5. Verify that subject is: “File Uploaded!”
         * Step 6. Verify that uploaded file name is displayed.
         * Note: use element.sendKeys(“/file/path”) with specifying path to the file
         for uploading. Run this method against “Choose File” button.
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/upload']")).click();
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath+"/"+filePath;
        driver.findElement(By.id("file-upload")).sendKeys(fullPath);;
        driver.findElement(By.cssSelector("#file-submit")).click();
        WebElement result = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(result.isDisplayed());
        Thread.sleep(5000);
    }

    @Test
    public void Tcase8() throws InterruptedException {
        /**
         * Test case #8
         * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
         * Step 2. And click on “Autocomplete”.
         * Step 3. Enter “United States of America” into country input box.
         * Step 4. Verify that following message is displayed: “You selected: United
         States of America”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
        WebElement inputbox = driver.findElement((By.xpath("//*[@*='myCountry']")));
        inputbox.sendKeys("United States of America");
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        Assert.assertTrue(result.isDisplayed(),"verify that message is displayed on scren , you selected unidet state of america");
        Thread.sleep(3000);

    }
}
