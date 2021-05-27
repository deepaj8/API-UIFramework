package com.test.API_UIAutomation.OneDat.TestBase;


import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

//import com.relevantcodes.extentreports.LogStatus;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;
import com.test.UIAutomation.OneDat.Utility.VideoRecorder;

import io.cucumber.java.Scenario;



public class testBase extends CommonFunctions {


	/************************* UI Functions ************************/
	
	
	public void setUp() {
		init();
	}
	

	public void startTest1(Method method) {
	//	test = extent.startTest(method.getName());
	//	test.log(LogStatus.INFO, method.getName() + "--Test Started");

	}
	
	
	public void afterMethod(Scenario scenario) throws Exception {
		getResult(scenario);
		// getScreenShot(result);
	}

	
	
	public void tearDown() throws Exception {
		closeBrowser();
		if (loadData("screenrecord").equalsIgnoreCase("yes")) {
			VideoRecorder.stopRecord();
		}

	}
	
	
	/************************* API Functions ************************/

}