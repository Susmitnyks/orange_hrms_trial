Feature: Test Edit My info functionality
  @Myinfo_upload
  Scenario: Verify successful profile picture uploading
    Given User is on the My info page
    When User clicks on the profile picture and clicks on + icon and Upload profile picture
    Then Profile picture uploaded should get save and show on application

  @Myinfo_updatedetails
  Scenario: Verify successful profile data update
    Given User is on the My info page
    When User enter Fname and Lname
    And  User update his birthdate
    And  User selects his nationality and click on save button
    Then User details should be saved succesfully

