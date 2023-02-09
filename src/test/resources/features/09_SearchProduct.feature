@TC009
Feature: Search Product

  Scenario: Search Product
    Given On the user automation homepage
    Then Verify that home page is visible successfully
    And Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Enter product name in search input and click search button
    Then Verify SEARCHED PRODUCTS is visible
    Then Verify all the products related to search are visible
