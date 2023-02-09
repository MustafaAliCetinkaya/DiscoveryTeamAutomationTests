@TC012
Feature: Add Products in Cart

  Scenario: Add Products in Cart
    Given On the user automation homepage
    Then Verify that home page is visible successfully
    And Click Products button
    And Hover over first product and click Add to cart
    And Click Continue Shopping button
    And Hover over second product and click Add to cart
    And Click View Cart button
    And Verify both products are added to Cart
    And Verify their prices, quantity and total price


