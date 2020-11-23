
Feature:FindTransactions Account Activity

  Background:
    Given user is on home page
    When user login with valid credentials
    Then user navigates to "Account Activity" module
    Then user clicks on 'Find Transactions' button

  Scenario: Search date range
    When the user enters date range from '2012-09-01'to '2012-09-06'
    And user clicks on 'Find' button
    Then results table should only show transactions dates between '2012-09-01' to '2012-09-06'
    And the results should be sorted by most recent date
    When the user enters date range from '2012-09-02'to '2012-09-06'
    And user clicks on 'Find' button
    Then results table should only show transactions dates between '2012-09-02' to '2012-09-06'
    And the results table should only not contain transactions dated '2012-09-01'
  @find_transaction
    Scenario: Search description
    When the user enters description 'ONLINE'
    And user clicks on 'Find' button
    Then results table should only show descriptions containing 'ONLINE'
    When the user enters description 'OFFICE'
    And user clicks on 'Find' button
    Then results table should only show descriptions containing 'OFFICE'
    But results table should not show descriptions containing 'ONLINE'

#  Scenario: Search description case insensitive
#   Given the user accesses the Find Transactions tab
#  When the user enters description 'ONLINE'
#    And clicks search
#    Then results table should only show descriptions containing 'ONLINE'
#  When the user enters description 'online'
#    And clicks search
#    Then results table should only show descriptions containing 'ONLINE'