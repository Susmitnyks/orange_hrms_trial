Feature: Verify Elements on the page.

  Background: User knows the flow.
  @Verify_name_test_case
  Scenario: Verify Logged-in username
    Given User is on the login page
    When User enters username and password
    And User clicks on the submit button
    And User is navigated to home page
    Then verify logged username