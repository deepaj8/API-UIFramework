package com.test.UIAutomation.OneDat.Utility;

import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class CheckBoxActions extends testBase{
	
	//These function basically check element is to be enabled, selected or displayed after certain amount of time otherwise it will through exception.
	public boolean checkElementToBeEnabled(WebElement el,int seconds) {
		int count = 0;
		boolean flag = false;
		try {
		do {
			if(el.isEnabled()) {
				flag = true;
				break;
			} else {
				count++;
				customWait.waitForSeconds(seconds);
			}
		} while (count < seconds);
			
		}catch (ElementNotVisibleException e) {
			log.error("Element not visible!!");
			flag=false;
		}  
		
		return flag;
	}
	
	
	public boolean checkElementToBeSelected(WebElement el, int seconds) {
		int count = 0;
		boolean flag = false;
		try {
		do {
			if(el.isSelected()) {
				flag = true;
				break;
			} else {
				count++;
				customWait.waitForSeconds(seconds);
			}
		} while (count < seconds);
		
		}catch (ElementNotSelectableException e) {
			log.error("Element not selectable!!");
			flag=false;
		}  
		
return flag;
}
	
	public boolean checkElementToBeDisplayed(WebElement el, int seconds) {
		int count = 0;
		boolean flag = false;
		try {
		do {
			if(el.isDisplayed()) {
				flag = true;
				break;
			} else {
				count++;
				customWait.waitForSeconds(seconds);
			}
		} while (count < seconds);
		
	}catch (ElementNotInteractableException e) {
			log.error("Element not interactible!!");
			flag=false;
		}  
		
		return flag;
}
	
	public void selectCheckBox(List<WebElement> elements, String text) {
		log.info("Number of Radio Buttons " + elements.size());
		for (WebElement el : elements) {
			String actualText = el.getText();
			log.info(actualText);
			if (actualText.equals(text)) {
				el.click();
				break;
			}
		}
	}
	
	
}