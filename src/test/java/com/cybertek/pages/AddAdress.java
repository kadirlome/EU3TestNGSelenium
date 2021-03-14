package com.cybertek.pages;

import com.cybertek.tests.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.record.chart.DatRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddAdress extends TestBase {
    @FindBy(id = "oro_contact_address_form_label-uid-603162dc8c44a")
    public WebElement label;
    @FindBy(css = "oro_contact_address_form_namePrefix-uid-603162dc8c553")
    public WebElement NamePrefix;
    @FindBy(css = "oro_contact_address_form_firstName-uid-603162dc8c64d")
    public WebElement FirstName;
    @FindBy(css = "oro_contact_address_form_lastName-uid-603162dc8c83a")
    public WebElement lastName;
    @FindBy(css = "s2id_oro_contact_address_form_country-uid-603162dc8cd77")
    public WebElement selectCountry;
    @FindBy(css = "oro_contact_address_form_city-uid-603162dc8d067")
    public WebElement city;

    @FindBy(css = "span[class='action-wrapper']>button[type='submit']")
    public WebElement save;

    public String dropdown(String country){
        WebDriver driver = new ChromeDriver();
        Select select=new Select(driver.findElement(By.cssSelector("s2id_oro_contact_address_form_country-uid-603162dc8cd77")));
        select.selectByVisibleText(country);
        return country;
    }
}
