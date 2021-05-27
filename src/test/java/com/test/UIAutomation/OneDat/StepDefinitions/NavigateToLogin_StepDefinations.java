package com.test.UIAutomation.OneDat.StepDefinitions;

import java.util.HashMap;

import org.testng.Assert;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Pages.OneDatHome;
import com.test.UIAutomation.OneDat.Pages.OneDatLogin;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToLogin_StepDefinations extends testBase{
	OneDatLogin login;
	OneDatHome home;
	
	@When("User clicks on BookStore link and then login link")
	public void user_clicks_on_book_store_link_and_then_login_link() {
		 home=pomanager.getHomePage();
		 home.navigateToLoginPage();
	    
	}
	@Then("User will be able to go to Login page")
	public void user_will_be_able_to_go_to_login_page() {
	   
		Assert.assertEquals(home.valText(), "Login");
	}
	
	
	@Then("User submits credentials from {string} file and {string} sheet")
	public void user_submits_credentials_from_file_and_sheet(String fileName, String sheetName) {
	   
		login=pomanager.getLoginPage();
		HashMap<String, String> data=excelReader.getData(fileName,sheetName,"LoginTest");
		login.loginToApplication(data);
	}
	
	@Then("User will be able to go to profile page")
	public void user_will_be_able_to_go_to_profile_page() {
		Assert.assertEquals(login.valText(),"Profile");
	    
	}

	

}
