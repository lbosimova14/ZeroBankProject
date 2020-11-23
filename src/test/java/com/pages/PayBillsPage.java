package com.pages;

import com.utils.BrowserUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class PayBillsPage extends BasePage {

    @FindBy(id = "sp_payee")
    public WebElement PaymentInputBox;
    @FindBy(id = "sp_account")
    public  WebElement AccountInputBox;
    @FindBy(id="sp_amount")
    public WebElement amountInputBox;
    @FindBy(id = "sp_date")
    public  WebElement dateInputBox;
    @FindBy(id="sp_description")
    public WebElement descriptionInputBox;
    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;
    @FindBy(id = "alert_content")
    public WebElement paymentSuccessMessage;
    @FindBy(xpath = "//*[contains(text(),'Add New Payee')]")
    public WebElement clickAddNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement  payeeName;
    @FindBy(id = "np_new_payee_address")
    public WebElement  payeeAddress;
    @FindBy(id = "np_new_payee_account")
    public WebElement  payeeAccount;
    @FindBy(id = "np_new_payee_details")
    public WebElement  payeeDetails;
    @FindBy(id = "add_new_payee")
    public WebElement  newPayeeAddButton;
    @FindBy(id="alert_content")
    public WebElement newPayeeSuccessfulMessage;



    public void selectPayment(String options){
        Select select = new Select(PaymentInputBox);
        BrowserUtil.waitForVisibility(PaymentInputBox,5);
        select.selectByVisibleText(options);
    }

    public void selectAccount(String options){
        Select select = new Select(AccountInputBox);
        select.selectByVisibleText(options);
    }
}