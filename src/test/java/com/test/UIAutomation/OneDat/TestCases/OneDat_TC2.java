package com.test.UIAutomation.OneDat.TestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.UIAutomation.OneDat.Pages.OneDatForm;
import com.test.UIAutomation.OneDat.Pages.OneDatHome;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDat_TC2 extends testBase{
    OneDatForm form;
	OneDatHome home;
	 
	@DataProvider(name="data")
	public Object[][] getTestDta(){
		return excelReader.getData("FormData","Data","FormTest");
	
	}
	
	@Test
	public void OneDat_NavigateToForms() {
		home=pomanager.getHomePage();
		home.navigateToFormPage();
		Assert.assertEquals(home.valText(), "Practice Form");
	}
	
	
	@Test(dataProvider="data")
	public void OneDate_SubmitFormInAppilication(HashMap<String, String> data) {
		
		form=pomanager.getFormPage();
		form.submitForm(data);
		Assert.assertEquals(form.confirmSubmit(),"Thanks for submitting the form");
	}

}
