@the_internet_login
Feature: Login functionality test.

  @login_valid
  Scenario: Verify with valid credentials
    Given i open "the-internet" product "login" page
    Then the page should open with "The Internet" title
    When i login with "tomsmith" username and "SuperSecretPassword!" password
    Then the success message should display within secure area page

#  @login_invalid
#  Scenario: Verify with invalid credentials
#    Given i open "the-internet" product "login" page
#    Then the page should open with "The Internet" title
#    When i login with "tomsmith" username and "invalid" password
#    Then the success message should display within secure area page
