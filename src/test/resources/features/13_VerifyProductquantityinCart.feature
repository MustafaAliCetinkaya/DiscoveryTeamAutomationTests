@TC013
  Feature:  Verify Product quantity in Cart

    Scenario: Verify Product quantity in Cart
      Given On the user automation homepage
      And Verify that home page is visible successfully
      And Click View Product for any product on home page
      And Verify product detail is opened
      And Increase quantity to 4
      And Click Add to cart button
      And Click View Cart button
      And Verify that product is displayed in cart page with exact quantity



