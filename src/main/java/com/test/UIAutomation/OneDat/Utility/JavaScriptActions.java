package com.test.UIAutomation.OneDat.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class JavaScriptActions extends testBase{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	// Highlight an Element
	public void highlightElement(WebElement el) {
		js.executeScript("arguments[0].style.border='4px solid yellow'", el);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.border=''", el);
	}
	
	public void clickHiddenElement(WebElement el) {
		js.executeScript("arguments[0].click();", el);
	}
	
	public String getHiddenElementText(WebElement el){
	    return (String) js.executeScript("return arguments[0].innerHTML", el);
	}
	
	public void sendTextToElement(WebElement el,String text) {
		js.executeScript("arguments[0].value='"+text+"'", el);
	}
	
	 //To scroll down the web page at the bottom of the page
	public void pageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // document.body.scrollHeight returns the complete height of the body i.e web page
	}
	
	public void pageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)"); 
	}
	
	
	//To scroll horizontal/down the web page by pixel.
	public void scrollRightByPixel() {
		js.executeScript("window.scrollBy(1000,0)");
	}
	
	public void scrollLeftByPixel() {
		js.executeScript("window.scrollBy(-1000,0)");
	}
	
	public void scrollDownByPixel() {
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void scrollUpByPixel() {
		js.executeScript("window.scrollBy(0,-1000)");
	}

	

	// To scroll down the web page by the visibility of the element.
	public void scrollVisibilityOfElement(WebElement el) {
	js.executeScript("arguments[0].scrollIntoView()", el); // #arguments[0]means first index of page starting at 0

	}
	
	//to inactive a element
	public void inActiveElement(WebElement e1) {
		js.executeScript("arguments[0].setAttribute('disabled','true');",e1);
	}


}
