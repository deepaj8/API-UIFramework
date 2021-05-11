package com.test.UIAutomation.OneDat.Utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class MultipleWindowActions extends testBase {

	public Iterator<String> getAllWindows() {
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}

	public void switchToBlankTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	public void switchToBlankWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	public void closeAllChildWindows() {
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandle);
		for (int i = 0; i < windowHandle.size(); i++) {
			if (windowList.get(i) != windowList.get(0)) {
				driver.switchTo().window(windowList.get(i)).close();
			}
		}
	}

	public int getWindowCount() {
		Set<String> windowHandle = driver.getWindowHandles();
		return windowHandle.size();

	}

	public void switchToWindow(WebElement el) {
		String parentWindowId = driver.getWindowHandle();
		el.click();
		Set<String> windowIds = driver.getWindowHandles();
		for (String window : windowIds) {
			if (!window.equals(parentWindowId)) {
				driver.switchTo().window(window);
			}
		}

	}

}
