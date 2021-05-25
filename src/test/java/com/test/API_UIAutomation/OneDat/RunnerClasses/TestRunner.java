package com.test.API_UIAutomation.OneDat.RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/com/test/UIAutomation/OneDat/FeatureFiles/NavigateToPortal.feature",
	  	glue={"classpath:com/test/UIAutomation/OneDat/StepDefinitions"},
		monochrome=true,
	    dryRun=false,
	    plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests {

}

