package com.test.UIAutomation.OneDat.StepDefinitions;

import java.lang.reflect.Method;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class hooksUI extends testBase{
	@Before
public void setUpApplication() {
		setUp();
	}
	
/*	@BeforeStep
public void beforeStep(Method method) {
		startTest1(method);
	}
*/	

	@After(order=1)
	public void afterStep(Scenario scenario) throws Exception {
			afterMethod(scenario);
			
		}
		
	
	@After(order=0)
public void tearDownApplication() throws Exception {
		tearDown();
	}

}
