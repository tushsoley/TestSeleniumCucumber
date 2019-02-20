@Smoke
Feature: Create a new firearm licence application
As a Application I want to create a online application for firearm licence
so that it can be processed for approval

Scenario Outline: Firearm license application for approved counrty
Given i login as "Applicant"
When i complete eligibility questions for Approved country "<Country>"
And i complete theory test
Then i should see theory test results
When i complete identification details
Then i should see application status as "PENDING-SUBMISSION"
When i complete Travel details for "Air"
When i complete visit details for "<Firearms related activity>"
And i select "<bringing firearms>" for bringing firearms
Then i should see my home country as "<Country>"
When i enter home country licence details
When i enter security questions as "<Security Arrangements>"


Examples:
|	Firearms related activity	|	bringing firearms	|	Country	|	Security Arrangements	|
|	Guided Hunting	|	No	|	Australia	|	Yes	|
|	Firearms Competition Pistol Shooting	|	No	|	Australia	|	No	|
#|	Independent Hunting	|	No	|
 

#Scenario: Firearm license application for unapproved counrty
#
#
#Scenario: Firearm license and PTI application for approved counrty
#Scenario: Firearm license and PTI application for unapproved counrty
#Scenario: Firearm license application for US counrty