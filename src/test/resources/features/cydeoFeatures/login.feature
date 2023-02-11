@Regression @login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts. And dashboard should be displayed.

  Accounts are: librarian, student, admin

  #Background:
  #    - Background is very similar to @BeforeMethod in TestNG.
  #    - @BeforeMethod executes given code/method before each Test in that SPECIFIC CLASS.
  #
  #    - Background runs before each SCENARIO in that SPECIFIC FEATURE FILE.
  #    - The step we pass under the "Background:" will execute only once before each step
  #
  #    - Important thing to keep in mind is that "Background" will be applying to each and every scenario in the same feature file.
  #    - Therefore we must make sure every scenario is able to pick up and continue where the background is leaving the code.
  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the library login page

  @librarian @employee
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

  @student @db
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard

  @admin @employee
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard

#this is how we add comments in feature file