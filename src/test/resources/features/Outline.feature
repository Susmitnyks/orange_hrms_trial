Feature: Verify Login with different Credentials.
  @Login_test_case_outline
  Scenario Outline: Verify Login with Valid Credentials
    Given User is on the login page
    When User will enters "<Username>" and "<Password>"
    And  User clicks on the submit button
    Then User lands on the homepage
    And  User do logout
    Examples:
    | Username | Password  |
    | Admin   | admin123  |
    | Charlie.Carter| Charlie@123 |