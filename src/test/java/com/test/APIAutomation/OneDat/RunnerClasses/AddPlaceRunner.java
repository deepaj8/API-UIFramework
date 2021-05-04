package com.test.APIAutomation.OneDat.RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/com/test/APIAutomation/OneDat/FeatureFiles",
glue={"classpath:com/test/APIAutomation/OneDat/StepDefinitions"},
monochrome=true)



public class AddPlaceRunner extends AbstractTestNGCucumberTests{

}
