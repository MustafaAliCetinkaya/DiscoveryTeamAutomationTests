@TC002
Feature: Login User with correct email and password

  Scenario: Login User with correct email and password
    Given On the user automation homepage
    Then Verify that home page is visible successfully
    And Click on Signup  Login button
    Then Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    Then Verify that Logged in as username is visible
    And Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible