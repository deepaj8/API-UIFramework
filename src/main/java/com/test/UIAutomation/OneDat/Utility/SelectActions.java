package com.test.UIAutomation.OneDat.Utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class SelectActions extends testBase{
	
	public void selTextFromDropDown(WebElement el, String selDropDownOption) {
		Select sel=new Select(el);
		List<WebElement> listelements=sel.getOptions();
		
		for(WebElement element:listelements) {
			String text=element.getText();
			
			if(text.equalsIgnoreCase(selDropDownOption))
			{
				element.click();
				log.info("Option Selected from Dropdown");
				break;
			}
		}
		
	}
	
	public void selByVisibleText(WebElement el, String selDropDownOption) {
		Select sel=new Select(el);
		sel.selectByVisibleText(selDropDownOption);
	}
	
	public void selByIndex(WebElement el, int selDropDownOption) {
		Select sel=new Select(el);
		sel.selectByIndex(selDropDownOption);
	}
	
	public void selByValue(WebElement el, String selDropDownOption) {
		Select sel=new Select(el);
		sel.selectByValue(selDropDownOption);
	}

}
