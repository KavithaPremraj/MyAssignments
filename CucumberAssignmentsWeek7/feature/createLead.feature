Feature: CreateLead
#Background:
#Given Launch the Chrome Browser
#And Enter the URL and maximize


Scenario Outline: Positive Login

And Enter the Username as <UserName>
And Enter the password as <Password>
When Click on the login button
When Click on the CRMSFA link
And Click on the leads
And Click on the Create Leads 
And Enter the CompanyName
And Enter the firstName
And Enter the LastName
And Click submit button
Then Verify the Viewlead page should be displayed

Examples:
|UserName|Password|
|'democsr'|'crmsfa'|
#|'demosalesmanager'|'crmsfa'|


Scenario: Negative Login
And Enter the Username as "demoCSR"
And Enter the password as "crm"
When Click on the login button
But Verify the error message should be displayed