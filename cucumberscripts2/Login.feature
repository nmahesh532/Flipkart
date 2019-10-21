Feature: Login Module

@Sanity
Scenario: Verify user is able to login with valid credentails
Given If user is on home page
When  Click on Signin link
And   Enter user name and password
Then  Verify logout link
Then  Close the browser

@Regression @Sanity
Scenario: Verify user is able to navigate to Account Info page
Given If user is on home page
When  Click on Signin link
And   Enter user name and password
And   Click Account Info link
Then  Verify Account Info page
Then  Close the browser

@Regression
Scenario: Verify user is able to navigate to Account Info page
Given If user is on home page
When  Click on Signin link