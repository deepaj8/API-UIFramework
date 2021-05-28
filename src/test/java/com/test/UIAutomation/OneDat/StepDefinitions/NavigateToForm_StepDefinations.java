package com.test.UIAutomation.OneDat.StepDefinitions;

import java.util.HashMap;

import org.testng.Assert;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Pages.OneDatForm;
import com.test.UIAutomation.OneDat.Pages.OneDatHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToForm_StepDefinations extends testBase{
	OneDatForm form;
	OneDatHome home;
	 
	
	@When("User clicks on Forms link and then practice form link")
	public void user_clicks_on_forms_link_and_then_practice_form_link() {
		home=pomanager.getHomePage();
		home.navigateToFormPage();
	}
	@Then("User will be able to go to Form page")
	public void user_will_be_able_to_go_to_form_page() {
		Assert.assertEquals(home.valText(), "Practice Form");
	}
	@Then("User submits details from {string} file and {string} sheet")
	public void user_submits_details_from_file_and_sheet(String fileName, String sheetName) {
		form=pomanager.getFormPage();
		HashMap<String, String> data=excelReader.getData(fileName,sheetName,"FormTest");
		form.submitForm(data);
	}
	
	@Then("User will be able to submit form data successfully")
	public void user_will_be_able_to_submit_form_data_successfully() {
	
		Assert.assertEquals(form.confirmSubmit(),"Thanks for submitting the form");
	}

	}

