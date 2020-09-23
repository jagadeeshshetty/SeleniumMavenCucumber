@feature1
Feature: Feature 1

  @scenario1
  Scenario: Scenario 1
    Given user is on login page
    When user enters username and password
    And clicks on the login button
    Then user is navigated to the home page

  @scenario2
  Scenario: Scenario 2
    Given user is on login page
    When user enters username and password
    And clicks on the login button
    Then user is navigated to the home page

#    @scenario3
#    Scenario Outline: Scenario 3
#      Given user is on login page
#      When user enters <username> and <password>
#      And clicks on the login button
#      Then user is navigated to the home page
#      Examples:
#            |username|password|
#            |user1   |pass1   |
#            |user2   |pass2   |
