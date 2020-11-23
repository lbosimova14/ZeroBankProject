@account_summary
Feature: Account Summary page
  Background:
    Given user is on home page
    When user login with valid credentials
    Then user navigates to "Account Summary" module

  Scenario: Account summary page should have the title Zero –Account summary.
  Then user verifies that "Zero - Account Summary" page subtitle is displayed

  Scenario: Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts
    Then user verifies that following account types
    |Cash Account|
    |Investment Accounts|
    |Credit Accounts    |
    |Loan Accounts      |

    Scenario: Credit Accounts table must have columns Account, Credit Card and Balance.
      Then user verifies Credit Accounts table have following columns
      |Account|
      |Credit Card|
      |Balance    |