@TC006
Feature: Contact us form

  Scenario: TC006 Contact us form
    Given On the user automation homepage
    And Verify that home page is visible successfully
    And Click on Contact Us button
    Then Verify GET IN TOUCH is visible
    And Enter name, email, subject and message
    And Upload file
    And Click Submit button
    And Click OK button
    Then Verify success message Success! Your details have been submitted successfully. is visible
    And Click Home button and verify that landed to home page successfully

