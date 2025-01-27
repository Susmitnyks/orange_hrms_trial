Feature: test the BDD cucumber functionality.
  Background: This is run before any scenario.
      Given User is on the test login page
      When User enters username and pincode.
    |Susmit_user|425001|
      And user click on submit button.
      Then User will land on homepage.
  # product one comment
  @Product_one
  Scenario: This is Scenario one.
    Given user on home page
    When user click on product one
    And user click on add to cart
    Then product one is added
  @Product_two
  Scenario: This is Scenario two.
    Given user on home page
    When user click on product two
    And user click on add to cart
    Then product two is added


