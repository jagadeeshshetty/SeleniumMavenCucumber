@all @featureOutlook
Feature: Test feature

  Background:
    Given A precondition

  @featureOutlookTestScenario1
  Scenario: Test scenario 1
    When Perform an action
    Then Validate the action
    And Validate other action
    But Validate negative action

  @featureOutlookTestScenario2
  Scenario: Test scenario 2
    When Perform an action
    Then Validate the action
