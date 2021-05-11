package com.test.UIAutomation.OneDat.Utility;

import java.time.Duration;



import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class CustomWait extends testBase {
	public static WebDriverWait wait;
	public static FluentWait<WebDriver> fluent;

	// ExplicitWait for an WebElement
	public void waitForVisibilityOfElement(WebElement el, WebDriver driver, int seconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(el));
		} catch (TimeoutException e) {
			log.error("Element is not visible in specified amount of time!!");
		}
	}
	
	//we can use one of the waits based on requirement 
	public void waitForVisiblityOfElement(WebElement e1,String s, WebDriver driver,int s1,int s2)
	{
		try {
			if(s.equals("explicit")) {
				wait=new WebDriverWait(driver,Duration.ofSeconds(s1));
				wait.until(ExpectedConditions.visibilityOf(e1));
			}
			else if(s.equals("fluent")) {
				fluent=new FluentWait<WebDriver>(driver);
				fluent.pollingEvery(Duration.ofSeconds(s2));
				fluent.withTimeout(Duration.ofSeconds(s1));
				fluent.until(ExpectedConditions.visibilityOf(e1));    
				
			}
		}
		catch(TimeoutException  e) {
			log.error("Element is not visible in specified amount of time");
		}
	}

	public void waitForElementToBeClickble(WebElement el, WebDriver driver, int seconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeClickable(el));
		} catch (TimeoutException e) {
			log.error("Element is not clickable in specified amount of time!!");
		}
	}

	public void waitForPageTitle(String pagetitle, WebDriver driver, int seconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.titleIs(pagetitle));
		} catch (TimeoutException e) {
			log.error("Could not get Page Title in specified amount of time!!");
		}
	}

	public void waitForElementToBeSelected(WebElement el, WebDriver driver, int seconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeSelected(el));
		} catch (TimeoutException e) {
			log.error("Element is not selectable in specified amount of time!!");
		}
	}

	// FluentWait for an WebElement
	/*public void fluentWaitForMethod(WebDriver driver,final WebElement el) {
		FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		
		Function<WebDriver,WebElement> function=new Function<WebDriver,WebElement>(){

			public WebElement apply(WebDriver t) {
				
			if(el!=null) {
				el.click();
			}
				return el;
			}
			
		};
		fluentwait.until(function);
	}*/

	public void waitForPageToLoad(WebElement webelement, int seconds) {
		log.info("Inside waitForPageToLoad Utility");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(webelement));
		} catch (TimeoutException e) {
			log.error("Page is not loaded in specified amount of time!!");
		}
	}

	public void waitForPageToLoad(String pageTitle, int seconds) {
		log.info("Inside waitForPageToLoad Utility");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.titleIs(pageTitle));
		} catch (TimeoutException e)
		{
			log.error("Page is not loaded in specified amount of time!!");
		}
	}

	public void waitForAlertToPresent(WebDriver driver, int seconds) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
		}catch (TimeoutException e)
		{
			log.error("Could not get Alert Window in specified amount of time!!");
		}
	}

	public boolean checkAlertToBePresent() {
		try {
			Alert a = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIME_OUT))
					.until(ExpectedConditions.alertIsPresent());
			if (a != null)
				log.info("Alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			log.error("Alert isn't present!!");
			return false;
		} catch (TimeoutException e) {
			log.error("Alert isn't present!!");
			return false;
		}

	}
	//to check frame is present or not by using locator
	/*public boolean waitForFrameToBePresent(WebElement e) {
		try {
			Frame f=new WebDriverWait(getDriver(),Duration.ofSeconds(Constants.TIME_OUT))
					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(e));
			return true;
		}
		catch(NoSuchFrameException ex)
		{
			return false;
		}
		catch(TimeoutException ex) {
			return false;
		}
	}*/

	public void waitForSeconds(int seconds) {
		seconds = seconds * 1000;// to convert into milli seconds
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
