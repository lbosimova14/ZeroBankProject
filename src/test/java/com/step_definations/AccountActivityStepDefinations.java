package com.step_definations;

import com.pages.AccountActivityPage;
import com.pages.AccountSummaryPage;
import com.utils.BrowserUtil;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountActivityStepDefinations {
    private  static Logger logger= Logger.getLogger(AccountActivityStepDefinations.class);
            AccountActivityPage accountActivityPage=new AccountActivityPage();
            AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
           SimpleDateFormat simpleDateFormat;

    @Then("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        accountSummaryPage.navigateTo(link);
       logger.info("user clicked on "+ link+" link");
    }


    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {

    }

    @When("the user enters date range from {string}to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtil.wait(2);
        accountActivityPage.findTransactionFromDateInput.clear();
        accountActivityPage.findTransactionFromDateInput.sendKeys(fromDate);
        BrowserUtil.wait(2);
        accountActivityPage.findTransactionToDateInput.clear();
        accountActivityPage.findTransactionToDateInput.sendKeys(toDate);
        logger.info("User entered date range from "+fromDate+" to "+toDate );
    }

    @When("clicks search")
    public void clicks_search() {

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {

        for (int i = 1; i <= accountActivityPage.dateEnteredElement.size(); i++) {
            String transactionDate = accountActivityPage.returnValueFromTable(1, i);
            simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

            double date1 = simpleDateFormat.parse(fromDate).getTime();
            double date2 = simpleDateFormat.parse(toDate).getTime();
            double finalDate = simpleDateFormat.parse(transactionDate).getTime();
            Assert.assertTrue(finalDate >= date1 && finalDate <= date2);
        }
        logger.info("result table only showed transactions dates");
//        List<String> dates = accountActivityPage.getDatesList();
//        boolean check = false;
//        int fromLastDigit =Integer.parseInt(fromDate.replace("-",""));
//        int toLastDigit = Integer.parseInt(toDate.replace("-",""));
//        for(String each: dates){
//            int tempDigit =Integer.parseInt(each.replace("-",""));
//            if(tempDigit >= fromLastDigit && tempDigit <= toLastDigit ){
//                BrowserUtil.wait(3);
//                check =true;
//            }
//        }
//
//        Assert.assertTrue("Displayed date range is wrong",check);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<String> originalList = accountActivityPage.getDatesList();
        List<String> copy = new ArrayList(originalList);

        Collections.sort(originalList);
        Collections.reverse(originalList);

        Assert.assertEquals("Dates are not sorted",originalList,copy);
        logger.info("Dates are sorted");

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String notContainedTransDate) {
        List<String> dates = accountActivityPage.getDatesList();
        Assert.assertFalse("The date is contained in the list", dates.contains(notContainedTransDate));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String data) {
        BrowserUtil.waitForVisibility(accountActivityPage.descriptionElement,5);
        accountActivityPage.descriptionElement.clear();
          accountActivityPage.descriptionElement.sendKeys(data);
    }

    @Then("results table should only show descriptions containing {string}")//ONLINE
    public void results_table_should_only_show_descriptions_containing(String DescriptionData) {
        List<String> descriptions = accountActivityPage.getDescriptionsList();
        for(String each: descriptions){
            Assert.assertTrue("Entered descriptions is contained in the table ", each.contains(DescriptionData));
        }
    }

    @Then("results table should not show descriptions containing {string}")//ONLINE
    public void results_table_should_not_show_descriptions_containing(String DescriptionData ) {
        List<String> descriptions = accountActivityPage.getDescriptionsList();
        for(String each: descriptions){
            Assert.assertFalse("Description does not contained", each.contains(DescriptionData));
        }
    }
    }






