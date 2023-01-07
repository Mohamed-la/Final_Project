Feature: user login
   @smoke
Scenario: user can login with valid data
   Given user click on login button
   When entered user valid data
   Then   Login successfully
   @smoke
   Scenario: user can login with invalid data
      Given user click on login button
      When  entered user invalid data
      Then  Login failed