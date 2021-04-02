Feature: Assign the Incident

Scenario Outline: TC003-Assign the Incident to Software Group

Given Enter username as admin
And Enter password as India@123
When Click on Login Button
Given Enter Incident in Filter navigator and press ENTER
Given Search by incident <incidentNumber>
When Click on the first resulting Incident Number in Edit mode
Given Update the Assignment Group to <assignmentGroup>
Given Add Work notes
When click button <button>
When Click on the first resulting Incident Number
Then Verify whether the Assignment Group is <assignmentGroup>

Examples:
|incidentNumber|assignmentGroup|button|
|'INC0018142'|'Software'|'Update'|