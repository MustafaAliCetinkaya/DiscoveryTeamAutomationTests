Feature: Amazon Search
  @amazonSearch
  Scenario: TC01_User should be able to search item at the amazon website
    Given user navigate to the amazon homepage
    When user writes different items to the search box one by one
    Then user sorts the items by price from low to high
    And user adds the selected items to the cart one by one
    And user goes to the cart
    And user goes to the checkout page
    And user fills the related fields for payment