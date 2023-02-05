Feature: Amazon Search
  Scenario: User should be able to search item at the amazon website
    Given User navigate to the amazon homepage
    When User writes different items to the search box one by one
    And User sorts the items by price from low to high
    And User adds the selected items to the cart one by one
    And User goes to the cart
    And User goes to the checkout page
    Then User fills the related fields for payment