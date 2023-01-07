Feature: User can follow company website on social media accounts

 Scenario: user can follow company website on facebook
   Given user navigate to website
   When  user click on follow us facebook
   Then  FB follow done successfully
  @smoke
 Scenario:  user can follow company website on twitter
   Given user navigate to website
   When  user click on follow us twitter
   Then twitter follow done successfully
