package com.test.UIAutomation.OneDat.Pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDatLogin extends testBase{

	
	@FindBy(id="userName")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(id="newUser")
	WebElement newUserBtn;
	
	@FindBy(id="output")
	WebElement errorMsg;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//*[@class='main-header']")
	WebElement homePageHeader;
	
	public OneDatLogin() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(HashMap<String, String> data) {
		username.clear();
		log.info(data.get("UserName"));
		log.info(data.get("Password"));
		username.sendKeys(data.get("UserName"));
		password.clear();
		password.sendKeys(data.get("Password"));
		loginBtn.click();
		customWait.waitForVisibilityOfElement(logoutBtn, driver, 3);
		//log.info("logged into the application");
		
	}
	
	public String valText() {
		String actual=homePageHeader.getText();
		return actual;
	}
	


	
}
