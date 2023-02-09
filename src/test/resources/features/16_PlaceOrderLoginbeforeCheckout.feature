@TC016
Feature: Place Order: Login before Checkout

  Scenario: Place Order: Login before Checkout
    Given On the user automation homepage
    And Verify that home page is visible successfully
    And Click on Signup  Login button
    And Fill email, password and click Login button
    Then Verify  Logged in as username at top
    And Add products to cart
    And Click Cart button.
    Then Verify that cart page is displayed
    And Click Proceed To Checkout
    Then Verify Address Details and Review Your Order
    And Enter description in comment text area and click Place Order
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date.
    And Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully!
    And Click Delete Account button
    Then Verify ACCOUNT DELETED! and click Continue button




