Feature: Login Module

Background:
Given If user is on home page
When  Click on Signin link
 
@Sanity 
Scenario Outline: Verify user is able to login with valid credentails
And   Enter user name as "<User Name>" and password as "<Password>"
Then  Verify logout link
Then  Close the browser

Examples:
    | User Name | Password |
    | demo      | 1234     |
    | demo2     | 1234     |

@Regression 
Scenario: Verify user is able to navigate to Account Info page
And   Enter user name as "demo" and password as "1234"
And   Click Account Info link
Then  Verify Account Info page
Then  Close the browser

@DB
Scenario: Verify Data base values
And   Enter user name as "demo" and password as "1234"