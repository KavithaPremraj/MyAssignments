Feature: Login to LeafTap Applications

Scenario Outline: Positive Login
And Enter the Username as <UserName>
And Enter the password as <Password>
When Click on the login button

Examples:
|UserName|Password|
|'democsr'|'crmsfa'|

Scenario: Negative Login
And Enter the Username as "demoCSR"
And Enter the password as "crm"
When Click on the login button
But Verify the error message should be displayed