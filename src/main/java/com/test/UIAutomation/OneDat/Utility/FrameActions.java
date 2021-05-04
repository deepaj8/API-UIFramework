package com.test.UIAutomation.OneDat.Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class FrameActions extends testBase{
	/*public boolean isFramePresent(WebElement element)
	{
		return customWait.waitForFrameToBePresent(element);
	}*/
  
	public int getIFrameCount() {

		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		log.info(frames.size());
		return frames.size();
	}
	
	
	public int getFrameSetCount() {
		List<WebElement> frames=driver.findElements(By.tagName("frameset"));
		log.info(frames.size());
		return frames.size();
	}
	
	//Below utility is not yet completed based on the application will complete it
	public void switchToFrame() {
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		for(WebElement frame:frames) {
			driver.switchTo().frame(frame);
			}
		}
	}
	
	
