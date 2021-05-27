package com.test.UIAutomation.OneDat.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;
import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class OneDatChkUtility extends testBase{
WebDriver driver;
	
	@FindBy(id="dropdown-class-example")
	WebElement dropdown;
	
	@FindBy(id="alertbtn")
	WebElement alertbtn;
	
	@FindBy(id="show-textbox")
	WebElement showbtn;
	
	@FindBy(xpath="//img[@alt='Google']")
	WebElement el;
	
	public OneDatChkUtility(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void check() throws FilloException {
	//excelCount.executeQuery("sample","Update TC_Data set Item='zzzz' where Rep='Smith'");
		
	}
	
	
	public String valText() {
		String actual=el.getText();
		return actual;
	}
}
