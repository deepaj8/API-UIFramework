Feature: Navigating To The Form section of ToolsQA Application

Scenario:verify user is navigating to the portal and then go to the form section
Given User navigate to the ToolsQA application
When User clicks on BookStore section
When User clicks on Forms link and then practice form link
Then User will be able to go to Form page
And User submits details from "FormData" file and "Data" sheet
And User will be able to submit form data successfully