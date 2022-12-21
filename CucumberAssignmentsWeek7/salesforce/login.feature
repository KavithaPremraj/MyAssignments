Feature: Login Salesforce Application

#Background:
#Given Launch the Chrome Browser
#And Enter the URL and maximize


Scenario: Positive Login

And Enter the Username
And Enter the password
When Click on the login button
Then Verify home page is displayed
#Examples:
#|Username|Password|
#|'hari.radhakrishnan@qeagle.com'|'Testleaf$321'|


Scenario: Nagative Login

And Enter the Username
And Enter the Wrong password
When Click on the login button
But Verify error page is displayed
