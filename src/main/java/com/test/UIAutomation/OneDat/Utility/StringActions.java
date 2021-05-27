package com.test.UIAutomation.OneDat.Utility;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class StringActions extends testBase{

	//Below function can be used whenever common attributes are present in a page and we want to select any one like radio/checkboxes in a page
	public void selectText(List<WebElement> elements, String text) {
		log.info("Number of Elements Found " + elements.size());
		for (WebElement el : elements) {
			String actualText = el.getText();
			if (actualText.equals(text)) {
				log.info(actualText);
				el.click();
				break;
			}
		}
	}
	
	
	
}
