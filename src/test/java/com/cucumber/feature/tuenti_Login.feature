Feature: Tuenti login

Scenario: login without username and password
    Given user is on Home Page
    When user clicks on Sign in button
    Then user is displayed login screen
    

Scenario: Successful Login with Valid Credentials
	Given user is on Home Page
	When user clicks on Sign in button
	And User enters Credentials to LogIn
	| Username   | Password |
    | 684262289 | testtest |
    | ops_internacional+24@tuenti.com | testtest |
	Then Message displayed Login Successfully

Scenario: Error Login
	Given User is on Home Page
	When user clicks on Sign in button
	And User enters Credentials to LogIn
	| Username   | Password |
    | 6842622449 | error1 |
    | ops_internacional+24tuenti.c | error2 |
    | ops_internacional+24@tuenti | error2 |
	Then Message displayed Login error
	
Scenario: Successful LogOut
	Given user is on Home Page
	When user clicks on Sign in button
	And User enters Credentials to LogIn
	| Username   | Password |
    | 684262289 | testtest |
	And User LogOut from the Application
	Then Message displayed LogOut Successfully
		  	
 	