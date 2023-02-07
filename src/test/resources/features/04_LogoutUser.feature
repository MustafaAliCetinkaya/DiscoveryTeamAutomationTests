@TC004

Feature: Logout User

  Scenario: TC04 Logout User
    Given On the user automation homepage
    And Verify that home page is visible successfully
    And Click on Signup  Login button
    And Verify Login to your account is visible
    And Enter correct email address and password
    And Click login button
    And Verify that Logged in as username is visible
    And Click Logout button
    And Verify that user is navigated to login page