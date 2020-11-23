package com.step_definations;

import com.pages.AccountActivityPage;
import com.pages.LoginPage;
import com.pages.PayBillsPage;
import com.utils.BrowserUtil;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.Map;


public class PayBillsStepDefinations {

    private static Logger logger = Logger.getLogger(PayBillsStepDefinations.class);
    PayBillsPage payBillsPage = new PayBillsPage();
    LoginPage loginPage = new LoginPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("user selects payment type {string}")
    public void user_selects_payment_type(String paymentType) {
        payBillsPage.selectPayment(paymentType);
        logger.info("user selected " + paymentType + " payment option");

    }

    @Then("user selects account type {string}")
    public void user_selects_account_type(String account) {
        payBillsPage.selectAccount(account);
        logger.info("user selected " + account + " account option");
    }

    @Then("user enters payment amount {string}")
    public void user_enters_payment_amount(String amount) {
        payBillsPage.amountInputBox.sendKeys(amount);
         logger.info("user entered $"+amount);
}

    @Then("user enters date {string}")
    public void user_enters_date(String date) {
       payBillsPage.dateInputBox.sendKeys(date);
       logger.info("user entered "+date+" date");
    }

    @Then("user entered description {string}")
    public void user_entered_description(String description) {
    payBillsPage.descriptionInputBox.sendKeys(description);
    }
    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        if(button.equalsIgnoreCase("Sign in")){
            loginPage.LoginSignInButton.click();
        }else if(button.equalsIgnoreCase("Pay")){
            payBillsPage.payButton.click();
        }else if (button.equalsIgnoreCase("Find")){
           accountActivityPage.findButton.click();
       }else if(button.equalsIgnoreCase("Find Transactions")){
           accountActivityPage.FindTransSubModule.click();
       }else if(button.equalsIgnoreCase("Add New Payee")){
            payBillsPage.clickAddNewPayee.click();
//        }else if (button.equalsIgnoreCase("Purchase Foreign Currency")){
//            page.payBillsPage().clickPurchaseForeignCurrencyTab();

        }else{
            System.out.println("Invalid Button");
        }
           logger.info("user clicked "+ button +" button");
    }
    @Then("user verifies message {string} is displayed")
    public void user_verifies_message_is_displayed(String expectedMessage) {

        if (expectedMessage.equalsIgnoreCase("The payment was successfully submitted.")) {
            Assert.assertEquals(expectedMessage, payBillsPage.paymentSuccessMessage.getText());
    }   else if (expectedMessage.equalsIgnoreCase("Please fill out this field message!") ){
        Assert.assertEquals(expectedMessage,(payBillsPage.amountInputBox.getAttribute("validationMessage")));
    } else if (expectedMessage.equalsIgnoreCase("Please fill out this field message!") ) {
            Assert.assertEquals(expectedMessage, (payBillsPage.dateInputBox.getAttribute("validationMessage")));
        }else {
            System.out.println("Invalid message");
        }
        logger.info("user verified " + expectedMessage + " message displayed");
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        BrowserUtil.waitForVisibility(payBillsPage.payeeName,5);
        payBillsPage.payeeName.sendKeys(dataTable.get("Payee Name"));
        payBillsPage.payeeAddress.sendKeys(dataTable.get("Payee Address"));
        payBillsPage.payeeAccount.sendKeys(dataTable.get("Account"));
        payBillsPage.payeeDetails.sendKeys(dataTable.get("Payee details"));
        BrowserUtil.wait(2);
        payBillsPage.newPayeeAddButton.click();
        logger.info("User created new payee info");
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage=payBillsPage.paymentSuccessMessage.getText();
                Assert.assertEquals(expectedMessage,actualMessage);
                logger.info("user verified "+actualMessage +" successful message");
    }




}
