Feature: Resolve Incident

Scenario Outline: TC004-Resolve Incident

Given Enter username as admin
And Enter password as India@123
When Click on Login Button
Given Enter Incident in Filter navigator and press ENTER
Given Search by incident <incidentNumber>
When Click on the first resulting Incident Number in Edit mode
Given Update the incident with State as <state>
Given Enter Reolution Information with Resolve Code as <resolutionCode>
When click button <button>
When Click on the first resulting Incident Number
Then Verify whether the State is <state>

Examples:
|incidentNumber|state|button|resolutionCode|
|'INC0018142'|'Resolved'|'Resolve'|'Solved (Permanently)'|