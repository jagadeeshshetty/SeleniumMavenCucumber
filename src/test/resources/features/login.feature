@login
Feature: Login functionality test.

  @login_valid
  Scenario: Verify with valid credentials
    Given i open "the-internet" product "login" page
    Then the page should open with "The Internet" title
    When i login with "tomsmith" username and "SuperSecretPassword!" password
    Then the success message should display within secure area page
#    When i enter "tomsmith" entry into "USERNAME_INPUT" edit box on "login" page
#    And i press "ENTER" key into searchEditBox element
#    Then the new page should contain "Steve Jobs - Wikipedia" entry
