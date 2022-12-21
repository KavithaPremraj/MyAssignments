Feature: Login to the EditLead

Scenario Outline: EditLead

And Enter the Username as <UserName>
And Enter the password as <Password>
When Click on the login button
When Click on the CRMSFA link
And Click on the leads
And Click Find leads
And Enter first name
And Click Find leads button
And Click on first resulting lead
And Verify title of the page
And Click Edit
And Change the company name
And Click Update
Then Confirm the changed name appears

Examples:
|UserName|Password|
|'democsr'|'crmsfa'|