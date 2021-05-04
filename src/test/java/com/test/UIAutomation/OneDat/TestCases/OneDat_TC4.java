package com.test.UIAutomation.OneDat.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.UIAutomation.OneDat.Pages.OneDatElements;
import com.test.UIAutomation.OneDat.Pages.OneDatPortal;
import com.test.UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Utility.MouseActions;

public class OneDat_TC4 extends testBase {
	OneDatElements elements;
	OneDatPortal portal;
	@Test
	public void mouseActionOnElement()
	{
		portal=pomanager.getPortalPage();
		elements=pomanager.getElementsPage();
		jsActions.scrollVisibilityOfElement(portal.getElementLink());
		portal.navigateToElemensPage();
		jsActions.scrollVisibilityOfElement(elements.getDynamicProperties());
		elements.clickOnDynamic();
		WebElement e1=elements.getVisibleElement();
		customWait.waitForVisiblityOfElement(e1,"fluent", driver, 8,2);
		System.out.println(elements.getTextOfVisibleElement());
	}

}
