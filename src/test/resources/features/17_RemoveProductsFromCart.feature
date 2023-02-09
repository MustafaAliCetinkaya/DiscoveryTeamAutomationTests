@TC017
Feature: RemoveProductsFromCart

  Scenario: RemoveProductsFromCart
    Given On the user automation homepage
    Then Verify that home page is visible successfully
    And Add products to cart
    And Click Cart button.
    Then Verify that cart page is displayed
    And Click X button corresponding to particular product
    And Verify that product is removed from the cart
