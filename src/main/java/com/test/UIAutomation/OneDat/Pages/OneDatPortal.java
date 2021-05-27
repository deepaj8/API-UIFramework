package com.test.UIAutomation.OneDat.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;

public class OneDatPortal extends testBase{
	
	//@FindBy(xpath="//div[@class='card-body']/h5[text()='Book Store Application']")
	//WebElement bookStoreLink;
	
	@FindBy(xpath="//div[@class='category-cards']//div[6]")
	WebElement bookStoreLink;
	@FindBy(xpath="//div[@class='category-cards']/div[5]")
	WebElement interactionsLink;
	
	@FindBy(xpath="//*[@class='main-header']")
	WebElement homePageHeader;
	@FindBy(xpath="//*[text()='Elements']")
	WebElement elementsLink;
	
	
	public OneDatPortal() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToBookStoreApplication() {
		jsActions.pageDown();
		//bookStoreLink.click();
	}
	public void clickOnBookstoreLink()
	{
		bookStoreLink.click();
	}
	public WebElement getBookStoreLink()
	{
		return bookStoreLink;
	}
	public WebElement getElementLink()
	{
		return elementsLink;
	}
	public void disableHomePage()
	{
		jsActions.inActiveElement(interactionsLink);
	}
	
	public String valText() {
		String actual=homePageHeader.getText();
		return actual;
	}
	public void navigate_to_interaction_app() {
		interactionsLink.click();		
	}
	public void navigateToElemensPage()
	{
		elementsLink.click();
	}
}
