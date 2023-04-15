Feature: Application Login

Scenario: Login with valid credentials

Given open any Browser
And Navigate to Login Page
When User enter username as "suba@gmail.com" and Password as "Sun!@"
And User clicks on login button
Then User is able to successfully login 
