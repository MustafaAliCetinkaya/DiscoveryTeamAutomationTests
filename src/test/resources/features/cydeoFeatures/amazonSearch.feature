#TAGS: Tags are used to group different scenarios together
#    - We can use tags to include or exclude some scenarios.
#    - If we put the @Tag on top of the .feature file, it will effect the whole feature file
#    - If we put it on top of a Scenario, it will only effect that scenario
#    - You can have as many tags as you want for a feature file or a scenario
Feature: Amazon Search
  @amazonSearch
  Scenario: TC01_User should be able to search item at the given website
    Given user navigate to the amazon homepage
    When user writes different items to the search box one by one
    And user sorts the items by price from low to high
    And user adds the selected items to the cart one by one
    And user goes to the cart
    Then user goes to the checkout page

    #Given, When, Then, And, But
    #    --> all of these keywords we use in the feature files are only for communication (making sense) purpose
    #    --> they dont change the functionality of the step_definitions
    #- Our code will be executed in the order we create in the feature files.
    #- Each scenario will be executed by top to bottom, and each step will be calling it step_definition method from its own package &class.
    #GIVEN: is used for pre-conditions
    #Ex:
    #     Given user is already logged in and ready to do something
    #     Given user is already on the home page
    #     Given user is already on the login page
    #     Given user is already on the search page
    #
    #     Given I am on the search page
    #
    #     Given driver is logged in
    #     Given officer is logged in
    #
    #WHEN: is used for when some actions happen
    #    When user enters librarian user name
    #    When user clicks to some link
    #    When user searches for something
    #
    #AND: is used for when you many repeating lines of any keyword
    #BUT: is similar for "AND" but for when we are comparing or some negative scenario happening
    #THEN: is used for when the verification is happening
    #    - Then user should see title is something
    #
    #    - Then user should see the dashboard
    #
    #    - Then user should see the image is displayed