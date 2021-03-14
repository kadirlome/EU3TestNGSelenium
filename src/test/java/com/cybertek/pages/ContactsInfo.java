package com.cybertek.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsInfo extends BasePage {

    @FindBy(css = "div.pull-left>h1.user-name")
    public WebElement fullname;

    @FindBy(css = "a.phone")
    public WebElement phone;

    @FindBy(css = "a.email")
    public WebElement email;

    @FindBy(css = "span[class='action-wrapper']>button[type='button']")
    public WebElement addAdress;


}
