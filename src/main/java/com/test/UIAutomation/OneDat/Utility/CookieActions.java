package com.test.UIAutomation.OneDat.Utility;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class CookieActions extends testBase{
	
	 public FirefoxOptions disableCookieOnFirefox() {
		 // to disable the cookies for firefox,check privacy & settings of browser n in
		 // block cookie options are changing
		 FirefoxOptions options = new FirefoxOptions();
		 options.addPreference("network.cookie.cookieBehavior", 2);
		 //driver = new FirefoxDriver(options);
		 return options;
		
		 }

		 public ChromeOptions disablecookieOnChrome() {
		 // to disable the cookies for chrome
		 ChromeOptions options = new ChromeOptions();
		 HashMap<String, Object> prefs = new HashMap<String, Object>();
		 prefs.put("profile.default_content_settings.cookies", 2);
		 prefs.put("profile.block_third_party_cookies", true);
		 options.setExperimentalOption("prefs", prefs);
		 //driver = new ChromeDriver(options);
		 return options;
		
		 }
		 
		 public EdgeOptions OnEdge() {
			 HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
			 edgePrefs.put("profile.default_content_settings.popups", 0);
			 edgePrefs.put("profile.default_content_setting_values.notifications", 2);
			 edgePrefs.put("profile.default_content_setting_values.automatic_downloads" , 1);		
			 edgePrefs.put("profile.content_settings.pattern_pairs.*,*.multiple-automatic-downloads",1);
			 EdgeOptions options = new EdgeOptions();
			 options.setExperimentalOption("prefs",edgePrefs);
			 return options;
		 }
		 
		 public FirefoxProfile downloadFileOnFirefox() {
		 FirefoxProfile fxProfile = new FirefoxProfile();
		 fxProfile.setPreference("browser.download.folderList",2);
		 fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		 fxProfile.setPreference("browser.download.dir",Constants.DownloadDir);
		 fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
		 fxProfile.setPreference("browser.helperApps.neverAsk.openFile","text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");


		      return fxProfile;
		 }
}
