Feature: Create New Incident without mandatory fields filled

Scenario: TC001-Create New Incident without mandatory fields filled

Given Enter username as admin
Given Enter password as India@123
When Click on Login Button
Given Enter Incident in Filter navigator and press ENTER
When Click on Create New Link
When Enter the frame
When Click on Submit button
Then check for the error message