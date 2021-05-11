package com.test.APIAutomation.OneDat.RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/com/test/APIAutomation/OneDat/FeatureFiles/bookValidation.feature",
	  	glue={"classpath:com/test/APIAutomation/OneDat/StepDefinitions"},
		monochrome=true,
	  //dryRun=true,
	    //plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//will remove below code once we decide the type of the report
      plugin= {"pretty","html:target/cucumber-pretty", "json:target/CucumberTestReport.json","rerun:target/rerun.txt" })
      //plugin= {"pretty","json:target/cucumber-reports/CucumberTestReport.json"})

public class TestRunner extends AbstractTestNGCucumberTests {

}

