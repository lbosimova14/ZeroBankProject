package com.pages;

import com.utils.BrowserUtil;
import com.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(id = "user_login")
    public WebElement userLoginButton;

    @FindBy(id = "user_password")
    public WebElement userPasswordButton;

    @FindBy(className= "submit")
    public WebElement LoginSignInButton;

    @FindBy(xpath= "//div[@class='alert alert-error']")
    public WebElement LoginErrorMessage;

      public void login(String userName,String password){
          userLoginButton.sendKeys(userName);
          //userPasswordButton.sendKeys(password);
        //  LoginSignInButton.click();
          //or like that
         userPasswordButton.sendKeys(password, Keys.ENTER);

      }
      //another overloded method for read cridentioals from properties file.
    public void login(){
          login(ConfigurationReader.getProperty("UserName"),ConfigurationReader.getProperty("Password"));
    }
}
