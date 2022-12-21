Feature: Login to DuplicateLead

Scenario Outline: Duplicate Lead

And Enter the Username as <UserName>
And Enter the password as <Password>
When Click on the login button
When Click on the CRMSFA link
And Click on the leads
And Click Find leads
And Click phone
And Enter phone number as '99'
When Click Find Leads button
And Click Duplicate Lead
And Click submit button
Then Verify the Tittle page

Examples:
|UserName|Password|
|'democsr'|'crmsfa'|