package com.test.UIAutomation.OneDat.StepDefinitions;

import org.testng.Assert;

import com.test.UIAutomation.OneDat.Pages.OneDatPortal;
import com.test.UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToPortal_StepDefinations extends testBase{
	OneDatPortal portal;
	Scenario scenario;
	
	@Before
	public Scenario beforeScenario(Scenario scenario) {
		this.scenario=scenario;
		return scenario;
	}
	
	@Given("User navigate to the ToolsQA application")
	public void user_navigate_to_the_tools_qa_application() {
		portal=pomanager.getPortalPage();
	    
	}
	@When("User clicks on BookStore section")
	public void user_clicks_on_book_store_section() {
		portal.navigateToBookStoreApplication();
		portal.clickOnBookstoreLink();
	    
	}
	@Then("User will able to the home page of portal")
	public void user_will_able_to_the_home_page_of_portal() {
		System.out.println(portal.valText());
		Assert.assertEquals(portal.valText(), "Book Store");
		//getScreenShot("user_will_able_to_the_home_page_of_portal",scenario);
	   
	}
}
