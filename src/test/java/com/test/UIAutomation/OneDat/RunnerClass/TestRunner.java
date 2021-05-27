package com.test.UIAutomation.OneDat.RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/com/test/UIAutomation/OneDat/FeatureFiles",
	  	glue={"classpath:com/test/UIAutomation/OneDat/StepDefinitions"},
		monochrome=true,
	    dryRun=false,
	    plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests {

}

