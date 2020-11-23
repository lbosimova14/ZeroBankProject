@smoke
Feature: Smoke test
#flow of execution:
  # hook before-->background --> scenario--> hook after
  Background:
    Given user is on home page
    When user login with valid credentials

  Scenario Outline: Verify main modules

    Then user navigates to "<Main Module>" module
    Then user verifies that "<page subtitle>" page subtitle is displayed

    Examples: Data

    |Main Module      |  page subtitle |
    |Account Summary  |Zero - Account Summary   |
    |Account Activity |Zero - Account Activity   |
    |Transfer Funds   |Zero - Transfer Funds     |
    |Pay Bills        |Zero - Pay Bills          |
    |My Money Map     |Zero - My Money Map       |
    |Online Statements|Zero - Online Statements  |
