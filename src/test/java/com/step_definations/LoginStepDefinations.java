package com.step_definations;

import com.pages.LoginPage;
import com.utils.BrowserUtil;
import com.utils.ConfigurationReader;
import com.utils.Driver;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class LoginStepDefinations {

    LoginPage loginPage= new LoginPage();
private static Logger logger = Logger.getLogger(LoginStepDefinations.class);
    @Given("user is on home page")
    public void user_is_on_home_page() {
        logger.info("User is on home page");
        //opening  chrome browser by selecting from Driver class and pulling url from property file by reading ConfigReader class
        Driver.get().get(ConfigurationReader.getProperty("url"));
        loginPage.signInButton.click();


    }
    @When("user login with valid credentials")
    public void user_login_with_valid_credentials() {
        String username = ConfigurationReader.getProperty("UserName");
        String password = ConfigurationReader.getProperty("Password");
        loginPage.login(username, password);
        logger.info("User login with valid credentials");
    }



    @Then("user should able to see {string} page")
    public void user_should_able_to_see_page(String expectedTitle) {
        BrowserUtil.wait(2);
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        logger.info("User is on "+ expectedTitle+ " page");
    }

    @When("user login with invalid {string} and {string}")
    public void user_login_with_invalid_and(String user_name, String password) {
        loginPage.login(user_name,password);
        logger.info("User login in with invalid "+ user_name +" username and "+password+ " password. ");
    }

    @Then("error {string} message should displays")
    public void error_message_should_displays(String expectedErrorMessage) {
          String actualErrorMessage=loginPage.LoginErrorMessage.getText();
          BrowserUtil.waitForVisibility(loginPage.LoginErrorMessage,5);
          Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
          logger.info(expectedErrorMessage+" error message displayed");
    }

    @When("user login with blank {string} and {string} credentials")
    public void user_login_with_blank_and_credentials(String string, String string2) {

        loginPage.login(string,string2);
        logger.info("User login in with blank "+ string+" username and "+string2+" password");
    }



}
