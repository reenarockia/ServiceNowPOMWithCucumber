Feature: Update Existing Incident

Scenario Outline: TC002-Update Existing Incident

Given Enter username as admin
And Enter password as India@123
When Click on Login Button
Given Enter Incident in Filter navigator and press ENTER
Given Search by incident <incidentNumber>
When Click on the first resulting Incident Number in Edit mode
Given Update the incident with Urgency as <urgency>
And Update the incident with State as <state>
When click button <button>
When Click on the first resulting Incident Number
Then Verify whether the Urgency is <urgency>
Then Verify whether the State is <state>

Examples:
|incidentNumber|urgency|state|button|
|'INC0018142'|'1 - High'|'In Progress'|'Update'|