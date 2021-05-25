package com.test.UIAutomation.OneDat.StepDefinitions;

import com.test.UIAutomation.OneDat.TestBase.testBase;

import java.lang.reflect.Method;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class hooksUI extends testBase{
	@Before
public void setUpApplication() {
		setUp1();
	}
	
/*	@BeforeStep
public void beforeStep(Method method) {
		startTest1(method);
	}
*/	

	@After(order=1)
	public void afterStep(Scenario scenario) throws Exception {
			AfterMethod1(scenario);
			
		}
		
	
	@After(order=0)
public void tearDownApplication() throws Exception {
		tearDown1();
	}

}
