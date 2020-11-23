@AddNewPayee
Feature: Add new payee under pay bills

  Background:
    Given user is on home page
    When user login with valid credentials
    Then user navigates to "Pay Bills" module
  Scenario: Add a new payee
  Given user clicks on 'Add New Payee' button
  And creates new payee using following information
  |Payee Name     |The Law Offices of Hyde, Price & Scharks|
  |Payee Address  |100 Samest, Anytown, USA, 10001      |
  |Account        |Checking|
  |Payee details  |XYZ account|
  Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed