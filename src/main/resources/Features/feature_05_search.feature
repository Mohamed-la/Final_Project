Feature: check searching

  Scenario: choose item
    Given user choose the required item to buy: books
    When user choose name of book
    Then quit from the website