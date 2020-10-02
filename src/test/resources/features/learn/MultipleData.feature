@all @multipleSetOfData
Feature: Learn to handle multiple set of data using List<> Collection

  @multipleSetOfDataTest
  Scenario: Test with multiple set of data
    When I login with valid username and password
      | user_1 | pass_1 |
      | user_2 | pass_2 |
