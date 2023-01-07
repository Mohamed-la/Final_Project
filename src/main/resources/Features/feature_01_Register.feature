Feature: user registeration
  Scenario: register with data valid data
    Given user navigate to homepage
    When  user click on register button
    And user entered valid user data
   Then registeration successfully


    Scenario:register with invalid data
      Given user navigate to homepage
      When  user click on register button
      And user entered invalid user data
      Then registeration failed