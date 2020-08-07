Feature: LogIn functionalilty test

Scenario: Positive login

Given User open browser
And open URL
And User accept all cookies
When User click on SignIn button
And User Enter Email and password 
And User click on Log In button
Then User shold be bale to login successfully and navigate to the homepage