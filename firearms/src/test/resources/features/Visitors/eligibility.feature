@Eligibility
Feature: Eligibility page validation rules
As an applicant I should be able to provide for eligibility  to proceed with the application

#Scenario Outline: Unpproved country Warning messages
#Given i login as "Applicant"
#When I select country "<country>" on Eligibility Page
#Then I should see message for unapproved country "<text>"
#
#Examples:
#|	country	|	text	|
#|	Algeria	|	Your home country does not have the acceptable level of licensing of firearms, therefore it is unlikely that your Visitors Firearms Licence & PTI will be granted.	| 

Scenario: Total number of countries
Given i login as "Applicant"
Then Total countries available for selection is "242"