package com.test.UIAutomation.OneDat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class OneDatElements  extends testBase{
	@FindBy(xpath="//*[text()='Dynamic Properties']")
	WebElement dynamicproperties;
	@FindBy(id="enableAfter")
	WebElement enableElement;
	@FindBy(id="colorChange")
	WebElement colorChange;
	@FindBy(id="visibleAfter")
	WebElement visibleAfter;
	public OneDatElements(){
		PageFactory.initElements(driver,this);
	}
	public WebElement getDynamicProperties()
	{
		return dynamicproperties;
	}
	public WebElement getVisibleElement()
	{
		return visibleAfter;
	}
	public void clickOnDynamic()
	{
		dynamicproperties.click();
	}
	public String getTextOfEnableElement()
	{
		return enableElement.getText();
	}
	public String getTextOfVisibleElement()
	{
		return visibleAfter.getText();
	}

}
