@account_activity
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given user is on home page
    When user login with valid credentials
    Then user navigates to "Account Summary" module

  Scenario Outline: Savings account redirect
    Then the user clicks on '<Links>' link on the Account Summary page
    Then user verifies that "Zero - Account Activity" page subtitle is displayed
    And Account drop down should have '<Options>' selected

  Examples:Data

  |Links        | Options     |
  | Savings     | Savings     |
  | Brokerage   | Brokerage   |
  | Checking    | Checking    |
  | Credit Card | Credit Card |
  | Loan        | Loan        |


# we performed data driven testing by using Scenarion Outline with Examples, instead  of writing repeatable scenario below
#    Given the user is logged in
#  When the user clicks on 'Savings' link on the Account Summary page
#  Then the 'Account Activity' page should be displayed
#  And Account drop down should have 'Savings' selected
#
#  Scenario: Brokerage account redirect
#    Given the user is logged in
#  When the user clicks on 'Brokerage' link on the Account Summary page
#  Then the 'Account Activity' page should be displayed
#  And Account drop down should have 'Brokerage' selected
#
#  Scenario: Checking account redirect
#    Given the user is logged in
#  When the user clicks on 'Checking' link on the Account Summary page
#  Then the 'Account Activity' page should be displayed
#  And Account drop down should have 'Checking' selected
#
#  Scenario: Credit Card account redirect
#    Given the user is logged in
#  When the user clicks on 'Credit card' link on the Account Summary page
#  Then the 'Account Activity' page should be displayed
#  And Account drop down should have 'Credit Card' selected
#
#  Scenario: Loan account redirect
#    Given the user is logged in
#  When the user clicks on 'Loan' link on the Account Summary page
#  Then the 'Account Activity' page should be displayed
#  And Account drop down should have 'Loan' selected