@TC005

Feature: Register User with existing email

  Scenario: TC05 Register User with existing email
    Given On the user automation homepage
    And Verify that home page is visible successfully
    And Click on Signup  Login button
    And Verify New User Signup! is visible
    And Enter name and already registered email address
    And Click Signup button
    And Verify error Email Address already exist! is visible