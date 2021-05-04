package com.test.UIAutomation.OneDat.TestBase;


import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.LogStatus;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;
import com.test.UIAutomation.OneDat.Utility.VideoRecorder;


public class testBase extends CommonFunctions {


	@BeforeClass
	public void setUp() {
		init();
	}
	
	

	@BeforeMethod
	public void startTest(Method method) {
		test = extent.startTest(method.getName());
		test.log(LogStatus.INFO, method.getName() + "--Test Started");

	}
	
	

	@AfterMethod
	public void AfterMethod(ITestResult result) throws Exception {
		getResult(result);
		// getScreenShot(result);
	}

	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		closeBrowser();
		if (loadData("screenrecord").equalsIgnoreCase("yes")) {
			VideoRecorder.stopRecord();
		}

	}

}
