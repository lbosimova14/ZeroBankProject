package com.step_definations;

import com.pages.AccountSummaryPage;
import com.utils.BrowserUtil;
import com.utils.Driver;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefinations {
      private  static Logger logger= Logger.getLogger(AccountSummaryStepDefinations.class);
  AccountSummaryPage accountSummaryPage=new AccountSummaryPage();

    @Then("user navigates to {string} module")
    public void user_navigates_to_module(String Tab) {
        accountSummaryPage.navigateTo(Tab);
        logger.info("user clicked "+ Tab+" module");
    }


    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed(String expectedTitle) {

        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        logger.info("User verified page subtitle: "+expectedTitle+ " is displayed");

    }

    @Then("user verifies that following account types")
    public void user_verifies_that_following_account_types(List<String> expectedAccountTypes) {
        Assert.assertEquals(expectedAccountTypes,accountSummaryPage.accountTypes());
        logger.info("user verified following: " +expectedAccountTypes+" account types");

    }

    @Then("user verifies Credit Accounts table have following columns")
    public void user_verifies_Credit_Accounts_table_have_following_columns(List<String> expectedColumns) {

        Assert.assertEquals(expectedColumns,accountSummaryPage.columnNames());
        logger.info("user verified Credit Account table have following: "+expectedColumns+" columns");
    }
}
