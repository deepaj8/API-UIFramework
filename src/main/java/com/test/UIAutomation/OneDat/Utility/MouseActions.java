package com.test.UIAutomation.OneDat.Utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class MouseActions extends testBase {
	Actions action=new Actions(driver);

	//Performs moves to an element and click
	public void moveAndClickElement(WebElement el) {
		action.click(el).perform();

	}

	//Performs click and hold the element
	public void clickAndHoldElement(WebElement el) {
		action.clickAndHold(el).perform();

	}

	//Performs click and hold on the element and moves down the arrow until the specified keyDownNumber and enter
	public void clickAndHoldKeyDownElement(WebElement el, int keyDownNumber) {
		action.clickAndHold(el).perform();
		for (int i = 1; i < keyDownNumber; i++) {
			action.sendKeys(Keys.DOWN).perform();
		}
		action.sendKeys(Keys.RETURN).build().perform();
	}
	
	//perform right click on element
	public void rightClickOnElement(WebElement e1) {
		action.contextClick(e1).build().perform();
	}
	
	//perform double click on element
	public void doubleClickOnElement(WebElement e1) {
		action.doubleClick(e1).build().perform();
	}
	
	//perform drag and drop of elements
	public void dragAndDropOfElements(WebElement e1,WebElement e2) {
		action.dragAndDrop(e1, e2).build().perform();
	}
	
	//to perform  actions on sliders
	public void dragAndDropOfSliders(WebElement e1,int x,int y) {
		action.dragAndDropBy(e1, x, y).build().perform();
	}
}
