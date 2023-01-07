Feature: check coins
  Scenario: test Euro currency selection
    Given user open the website home page
    When  User chooses Euro currency
    Then Check that Euro is selected successfully
  @smoke
  Scenario: test Dollar currency selection
    Given user open the website home page
    When User chooses Dollar currency
    Then Check that Dollar is selected successfully