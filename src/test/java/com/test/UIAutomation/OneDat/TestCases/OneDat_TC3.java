package com.test.UIAutomation.OneDat.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.UIAutomation.OneDat.Pages.OneDatPortal;
import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDat_TC3 extends testBase {
	OneDatPortal portal;
	@Test
	public void onedat_navigateTo_interactions()
	{
		portal=pomanager.getPortalPage();
		portal.navigate_to_interaction_app();
		System.out.println(portal.valText());
		Assert.assertEquals(portal.valText(), "Interactions");
	}

}