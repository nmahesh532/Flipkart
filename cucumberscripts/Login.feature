Feature: Login Module
Scenario: Verify user is able to login with valid credentails
Given If user is on home page
When  Click on Signin link
And   Enter user name and password
Then  Verify logout link
Then  Close the browser