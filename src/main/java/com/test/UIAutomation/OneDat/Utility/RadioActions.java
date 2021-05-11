package com.test.UIAutomation.OneDat.Utility;

import java.util.List;


import org.openqa.selenium.WebElement;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class RadioActions extends testBase {

	public void selectRadioButton(List<WebElement> elements, String text) {
		log.info("Number of Radio Buttons " + elements.size());
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
