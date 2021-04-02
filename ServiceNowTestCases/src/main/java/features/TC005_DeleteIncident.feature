Feature: Delete Incident

Scenario Outline: TC005-Delete Incident

Given Enter username as admin
And Enter password as India@123
When Click on Login Button
Given Enter Incident in Filter navigator and press ENTER
Given Search by incident <incidentNumber>
When Click on the first resulting Incident Number in Edit mode
When click button <button>
Then Click Delete in the warning box
Given Search by incident <incidentNumber>
Then Verify for No Records to Display for incident <incidentNumber>

Examples:
|incidentNumber|button|
|'INC0011453'|'Delete'|