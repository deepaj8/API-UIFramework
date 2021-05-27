package com.test.UIAutomation.OneDat.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class OneDatHome extends testBase{
	
	@FindBy(xpath="//*[@class='main-header']")
	WebElement homePageHeader;
	
	@FindBy(xpath="//*[text()='Book Store Application']")
	WebElement bookStoreAppLink;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//*[text()='Forms']")
	WebElement formLink;
	
	@FindBy(xpath="//span[text()='Practice Form']")
	WebElement practiceFormLink;
	
	
	public OneDatHome() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void navigateToLoginPage() {
		jsActions.scrollVisibilityOfElement(bookStoreAppLink);
		customWait.waitForVisibilityOfElement(bookStoreAppLink, driver, 4);
		//bookStoreAppLink.click();
		loginLink.click();
	}
	
	public void navigateToFormPage() {
		customWait.waitForVisibilityOfElement(formLink, driver, 3);
		formLink.click();
		practiceFormLink.click();
	}
	
	public String valText() {
		String actual=homePageHeader.getText();
		return actual;
	}
	
	

}
