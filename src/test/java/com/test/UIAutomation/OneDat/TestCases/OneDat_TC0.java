package com.test.UIAutomation.OneDat.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.UIAutomation.OneDat.Pages.OneDatPortal;
import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDat_TC0 extends testBase{
	OneDatPortal portal;
	
	
	@Test
	public void OneDat_NavigateToPortal() {
		portal=pomanager.getPortalPage();
		portal.navigateToBookStoreApplication();
		portal.clickOnBookstoreLink();
		System.out.println(portal.valText());
		Assert.assertEquals(portal.valText(), "Book Store");
	}
	
	
	

}
