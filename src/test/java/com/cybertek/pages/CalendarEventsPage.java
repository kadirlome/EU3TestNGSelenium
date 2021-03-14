package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//*[@*='btn btn-link dropdown-toggle")
    public WebElement checkOption;

 // @FindBy(css = "input[class='input-widget']")
    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(css = "button[class='btn dropdown-toggle ']")
    public WebElement perPage;

    //table checkbox
    @FindBy(xpath = "//div/button/input[1]")
    public WebElement checkbox;


    //Total of .....
    @FindBy(css = "div>label:nth-of-type(3)")
    public WebElement totalOf;

    //table(rows)
    @FindBy(xpath = "//table/tbody/tr")
    public WebElement rowswebTable;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement lastpagenumber;

    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement lastRowNumber;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr")
    public List<WebElement> rowCount;

    public int tableCheckbox(){
        List<WebElement> listTable = Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        for(int i=1;i<=listTable.size();i++){
            WebElement list = Driver.get().findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr["+i+"]"));

        }

        return 0;
    }
// sonra sil bana ait
    public int recordCheck(){
        int recordCounters=0;
        List<WebElement> allrows = Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        return recordCounters;
    }

    public int recordsCheck(){
        int recordcounter=0;
        List<WebElement> allRows = Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        for (int i = 1; i<=allRows.size(); i++){
            WebElement row = Driver.get().findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr["+i+"]"));
            System.out.println(row.getText());
            recordcounter++;
        }
        return recordcounter;
    }
    public String getNumberOfLastPage(String text){
        int pipe = text.indexOf('|');
        String result = text.substring(2,pipe).trim();
        return result;
    }
    //Ben yaptim total icin
    public String getTotalNumber(String text){
        int pipe = text.indexOf('R');
        String result = text.substring(8,pipe).trim();
        return result;
    }

    public int getRecordCounter() {
        List<WebElement> rows = rowCount;
        return 25 - rows.size();//6
        // 164*25= 4100
        // 4100-6=4094
    }

}
