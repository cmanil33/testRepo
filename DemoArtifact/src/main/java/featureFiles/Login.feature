Feature: To validate the login functionlity for the phpTravel application


Scenario Outline: To verify the login functionlity

Given user is navigated to the application "https://www.phptravels.net/login" site
When user entered the <username> and <password>
And user clicked on login button
Then verify if user is successfully logged in

Examples:
|username			 |password   |
|user@phptravels.com |demouser   |
|user@phptravels.com |demouser123|
|user@phptravels.com |			 |


