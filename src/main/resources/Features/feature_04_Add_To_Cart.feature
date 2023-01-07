Feature: User Can Add product to cart

Scenario: valid scenario to add product to cart
    Given user navigate to the website
    When user use action hovar
    Then test the bar color green


 Scenario: invalid scenario to add product to cart
     Given user navigate to the website
     When user use action hovar invalid
     Then test the bar color red
