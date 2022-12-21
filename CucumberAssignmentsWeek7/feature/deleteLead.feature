Feature: Login to DeleteLead

Scenario Outline: Delete Lead

And Enter the Username as <UserName>
And Enter the password as <Password>
When Click on the login button
When Click on the CRMSFA link
And Click on the leads
And Click Find leads
And Get first resulting LeadID
And Click LeadIDInputBox
And Enter LeadID
When Click Find Leads button
And Click LeadID
And CLick Delete
And Click Find leads
And Enter the leadID
When Click Find Leads button
Then Verify No records to display

Examples:
|UserName|Password|
|'democsr'|'crmsfa'|