Feature: To verify the Flight Featues in the phpTravel application


@smoke
Scenario: To verify the different flight types dropdown contains - Economy, Business & First Class

Given user is navigated to the application "https://www.phptravels.net/login" site
When user clicked on Flights tab
Then verify if user is able to see "Economy" and "Business" and "First" flight types




