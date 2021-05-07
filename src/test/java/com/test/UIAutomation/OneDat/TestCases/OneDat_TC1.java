package com.test.UIAutomation.OneDat.TestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.UIAutomation.OneDat.PageObjectManager.PageObjectManager;
import com.test.UIAutomation.OneDat.Pages.OneDatHome;
import com.test.UIAutomation.OneDat.Pages.OneDatLogin;
import com.test.UIAutomation.OneDat.Pages.OneDatPortal;
import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDat_TC1 extends testBase{
	OneDatLogin login;
	OneDatHome home;
	 
	@DataProvider(name="data")
	public Object[][] getTestDta(){
		return excelReader.getData("Login","Credentials","LoginTest");
		
	}
	
	@Test
	public void OneDat_NavigateToLogin() {
		 home=pomanager.getHomePage();
		home.navigateToLoginPage();
		Assert.assertEquals(home.valText(), "Login");
	}
	
	
	@Test(dataProvider="data")
	public void OneDate_LoginToAppilication(HashMap<String, String> data) {
		
		login=pomanager.getLoginPage();
		login.loginToApplication(data);
		Assert.assertEquals(login.valText(),"Profile");
	}

}