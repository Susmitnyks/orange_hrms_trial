Feature: Test login and logout functionality

  @Login_test_case
  Scenario: Verify successful login with valid credentials
    Given User is on the login page
    When User enters username and password
    And User clicks on the submit button
    Then User is navigated to home page

  @Logout_test_case
  Scenario: Verify successful logout functionality
    Given User is on the login page
    When User enters username and password
    And User clicks on the submit button
    Then User clicks on logout button
    And User is navigated back to login screen