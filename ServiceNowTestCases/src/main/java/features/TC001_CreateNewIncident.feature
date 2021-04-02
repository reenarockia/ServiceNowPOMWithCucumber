Feature: Create New Incident

Scenario: TC001-Create New Incident

Given Enter username as admin
Given Enter password as India@123
When Click on Login Button
Given Enter Incident in Filter navigator and press ENTER
When Click on Create New Link
Then Store the Incident Number
When Select caller by clicking on the Lookup
And Select the caller in ServiceNow Users page
Given Enter Short Description
When Click on Submit button
Given Search by incidentNumber
When Click on the first resulting Incident Number
Then Verify whether the First Resulting Incident number is the same as that of the stored incident Number