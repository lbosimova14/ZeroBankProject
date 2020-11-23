
Feature: Pay Bills
  Background:
    Given user is on home page
    When user login with valid credentials
    Then user navigates to "Pay Bills" module

  Scenario: Pay Bills page should have the title Zero –Pay Bills.
    Then user verifies that "Zero - Pay Bills" page subtitle is displayed
  @pay_bills
   Scenario Outline: user completes a successful Pay operation
  Then  user selects payment type '<Payee>'
  Then user selects account type '<Account>'
  Then user enters payment amount '<Amount>'
  Then user enters date '<Date>'
  Then user entered description '<Description>'
   Then user clicks on 'Pay' button
  And user verifies message "The payment was successfully submitted." is displayed

     Examples: Data
  |Payee          |Account    |Amount  |Date         |Description|
  |Bank of America|Savings    |100     |05-18-2020   |for college|
  |Apple          |Checking   |50      |05-20-2010   |for rent  |
  |Sprint         |Loan       |300     |06-30-2020   |for car  |
  |Wells Fargo    |Credit Card|200     |05-20-2020   |for phone|

Scenario Outline: Negative Test:
  user tries to make a payment without entering the amount or date.
  Then user enters payment amount '<Amount>'
  Then user enters date '<Date>'
  Then user entered description '<Description>'
  Then user clicks on 'Pay' button
  And user verifies message "Please fill out this field!" is displayed

  Examples: Data
    |Amount   |Date         |Description|
    |         |05-18-2020   |for college|
    |50       |             |for rent   |


#Amount field should not accept alphabetical or special characters.
#  Date field should not accept alphabetical characters.