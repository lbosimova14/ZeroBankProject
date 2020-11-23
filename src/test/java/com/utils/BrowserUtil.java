package com.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void wait(int seconds){
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //This method will convert/retrieve list of WebElements into list of string
    public static List<String> getListOfString(List<WebElement> listOfWebElements){
        List<String> listOfString =new ArrayList<>();
        for(WebElement element: listOfWebElements){
         String value= element.getText().trim();
         if(value.length()>0){
             listOfString.add(value);
         }
        }
        return listOfString;
    }

    public static WebElement waitForVisibility(WebElement element,int timeToWaitInSec){
        WebDriverWait wait =new WebDriverWait(Driver.get(),timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
