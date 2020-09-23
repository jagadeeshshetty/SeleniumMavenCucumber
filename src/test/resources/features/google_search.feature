@google_search
Feature: Google search functionality test.

  @google_valid_string_search
  Scenario: Verify google search functionality with valid string
    Given i open google search page
    When i enter "steve jobs" entry into searchEditBox element
    And i press "ENTER" key into searchEditBox element
    Then the new page should contain "Steve Jobs - Wikipedia" entry

  @google_invalid_string_search
  Scenario: Verify google search functionality with valid string
    Given i open google search page
    When i enter " " entry into searchEditBox element
    And i press "ENTER" key into searchEditBox element
#    Then the new page should contain "Steve Jobs - Wikipedia" entry
