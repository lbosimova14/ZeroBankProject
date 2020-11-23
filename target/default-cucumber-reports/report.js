$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/account.activity/findTransactions.feature");
formatter.feature({
  "name": "FindTransactions Account Activity",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on home page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinations.user_is_on_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinations.user_login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to \"Account Activity\" module",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountSummaryStepDefinations.user_navigates_to_module(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027Find Transactions\u0027 button",
  "keyword": "Then "
});
formatter.match({
  "location": "PayBillsStepDefinations.user_clicks_on_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search description",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@find_transaction"
    }
  ]
});
formatter.step({
  "name": "the user enters description \u0027ONLINE\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "AccountActivityStepDefinations.the_user_enters_description(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027Find\u0027 button",
  "keyword": "And "
});
formatter.match({
  "location": "PayBillsStepDefinations.user_clicks_on_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show descriptions containing \u0027ONLINE\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountActivityStepDefinations.results_table_should_only_show_descriptions_containing(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters description \u0027OFFICE\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "AccountActivityStepDefinations.the_user_enters_description(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027Find\u0027 button",
  "keyword": "And "
});
formatter.match({
  "location": "PayBillsStepDefinations.user_clicks_on_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show descriptions containing \u0027OFFICE\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountActivityStepDefinations.results_table_should_only_show_descriptions_containing(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should not show descriptions containing \u0027ONLINE\u0027",
  "keyword": "But "
});
formatter.match({
  "location": "AccountActivityStepDefinations.results_table_should_not_show_descriptions_containing(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});