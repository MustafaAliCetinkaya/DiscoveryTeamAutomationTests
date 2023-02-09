@TC010
Feature: Verify Subscription in home page

  Scenario: Verify Subscription in home page
    Given On the user automation homepage
    Then Verify that home page is visible successfully
    And Scroll down to footer
    And Verify text SUBSCRIPTION
    And Enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible