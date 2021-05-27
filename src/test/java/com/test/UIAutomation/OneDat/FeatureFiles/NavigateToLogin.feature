Feature: Navigating To The Login section of ToolsQA Application

Scenario:verify user is navigating to the portal and then login to the application
Given User navigate to the ToolsQA application
When User clicks on BookStore section
When User clicks on BookStore link and then login link
Then User will be able to go to Login page
And User submits credentials from "Login" file and "Credentials" sheet
And User will be able to go to profile page