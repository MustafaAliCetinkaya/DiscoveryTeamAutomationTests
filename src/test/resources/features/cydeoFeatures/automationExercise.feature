Feature:Search Product Functionality
@outlineExercise
  Scenario Outline:
    Given User is on the automation webpage
    When Verify that home page is visible successfully
    And User clicks on the products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And User types "<searchKeyword>" to the search box and clicks on the search button
    Then First search result's "<productName>" should contain search keyword
    Then First search result's price should be "<price>"
  Examples:
    | searchKeyword | productName | price |
    | blue  | Blue Top             | 500  |
    | men   | Men Tshirt           | 400  |
    | women | Madame Top For Women | 1000 |
    | kid   | Frozen Tops For Kids | 278  |