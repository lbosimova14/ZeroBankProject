
  Feature: Only authorized users should be able to login to the application.
    Background:
      Given user is on home page
@validCredentials
  Scenario:   user logsin with valid credentials, Account summary page should be displayed.
    When user login with valid credentials
    Then user should able to see "Zero - Account Summary" page
@invalidCredentials
    Scenario: User with invalid credentials should not be login in
      When user login with invalid "invalidUserName" and "invalidPassword"
      Then  error "Login and/or password are wrong." message should displays
@blankCredentials
    Scenario: User with  blank credentials should not be login in
      When user login with blank " " and " " credentials
      Then  error "Login and/or password are wrong." message should displays