package com.test.UIAutomation.OneDat.Utility;



import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class AlertActions extends testBase {

	public boolean isAlertPresent() {
		return customWait.checkAlertToBePresent();
	}

	public void acceptAlert() {
		if (isAlertPresent() == true)
			
		{
			driver.switchTo().alert().accept();
			log.info("Alert is accepted");
		}
	}

	public void dismissAlert() {
		if (isAlertPresent() == true)
			
		{
			driver.switchTo().alert().dismiss();
			log.info("Alert is dismissed");
		}
	}

	public String getAlertText() {
		if (isAlertPresent() == true)
			
		{
			String text = driver.switchTo().alert().getText().trim();
			driver.switchTo().alert().accept();
			if (text.length() > 0) {
				return text;
			}
		}
		return "No text present in alert window";
	}
	public void sendTextToAlert(String text) {
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().sendKeys(text);
		}
	}
}
