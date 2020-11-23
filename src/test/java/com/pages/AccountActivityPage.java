package com.pages;

import com.utils.BrowserUtil;
import com.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends  BasePage{


    @FindBy(linkText = "Find Transactions")
    public  WebElement FindTransSubModule;

    @FindBy(xpath = "//button[@type='submit'][@class='btn btn-primary']")
    public WebElement findButton;

    @FindBy(id = "aa_accountId")
    public  WebElement accountTypeDropDown;

    @FindBy(id = "aa_fromDate")
    public WebElement findTransactionFromDateInput;

    @FindBy(id = "aa_toDate")
    public WebElement findTransactionToDateInput;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> dateEnteredElement;

    @FindBy (id="aa_description")
    public WebElement descriptionElement;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    public List<WebElement> descriptionResultElement;

    public List<String> getDatesList(){
        List<String> listofDates=new ArrayList<>();
        for (WebElement each: dateEnteredElement) {
            if(!each.getText().isEmpty()){
                listofDates.add(each.getText());
            }
        }
        return  listofDates;
    }
    public List<String> getDescriptionsList(){
        BrowserUtil.wait(2);
        return BrowserUtil.getListOfString(descriptionResultElement);
    }


    public String returnValueFromTable(int column , int row){
        String cellValue = null;
        try {
            WebElement cell = Driver.get().findElement(By.xpath("(//tbody)[2]/tr[" + row + "]/td[" + column + "]"));
            cellValue = cell.getText();
        }catch (RuntimeException e){
            System.out.println("no such cell exists");
            cellValue = null;
        }
        return cellValue;
    }

}
