package com.pages;

import com.utils.BrowserUtil;
import com.utils.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class BasePage {
    private static Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(id = "signin_button")
    public WebElement signInButton;


//    @FindBy (xpath = "//*[.='Cash Accounts']")
//    public WebElement accountTypes;


    //insight constructor PageFactoy initializing WebElements
    public BasePage()
    {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateTo(String moduleName) {
        String moduleLocator="//a[contains(text(),'"+moduleName+"')]";
        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));
        BrowserUtil.waitForVisibility(module,5);
        module.click();


}
}