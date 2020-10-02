@all @failScenarios
Feature: Fail scenarios

  @arithmeticExceptionFailUncheckedException
  Scenario: Fail by ArithmeticException
    When I try to divide number by zero

  @arithmeticExceptionFailCheckedException
  Scenario: Fail by ArithmeticException
    When I try to divide number by zero with checked exception
