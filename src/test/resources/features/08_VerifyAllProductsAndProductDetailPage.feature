
  @TC008
  Feature: Verify All Products and product detail page

    Scenario: TC008 Verify All Products and product detail page
      Given On the user automation homepage
      And Verify that home page is visible successfully
      And Click on Products button
      And Verify user is navigated to ALL PRODUCTS page successfully
      Then The products list is visible
      And Click on View Product of first product
      And User is landed to product detail page
      Then Verify that detail detail is visible: product name, category, price, availability, condition, brand