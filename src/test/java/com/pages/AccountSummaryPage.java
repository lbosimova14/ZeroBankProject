package com.pages;

import com.utils.BrowserUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypesElement;

    @FindBy(xpath = "//div[3]/div/table/thead/tr/th")
    public  List<WebElement> TableColumnNamesElement;

    @FindBy(tagName = "a")
    public List<WebElement> links;


    public List<String> accountTypes() {

        return BrowserUtil.getListOfString(accountTypesElement);
    }

    public List<String> columnNames() {

        return BrowserUtil.getListOfString(TableColumnNamesElement);
    }

    public void getLinks(String link)throws Exception{
        try {
            for (WebElement myElement : links){
                 link = myElement.getText();
                if (link !=""){
                    myElement.click();
                }
            }
        }catch (Exception e){
            System.out.println("error "+e);
        }
    }
}