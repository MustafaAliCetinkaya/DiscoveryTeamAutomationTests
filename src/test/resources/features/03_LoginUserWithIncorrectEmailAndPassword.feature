@TC003
Feature: Login User with incorrect email and password

  Scenario: Login User with incorrect email and password
    Given On the user automation homepage
    Then Verify that home page is visible successfully
    And Click on Signup  Login button
    Then Verify Login to your account is visible
    And Enter incorrect email address and password
    And Click login button
    And Verify error Your email or password is incorrect! is visible