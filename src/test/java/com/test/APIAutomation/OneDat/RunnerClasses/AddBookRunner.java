package com.test.APIAutomation.OneDat.RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/com/test/APIAutomation/OneDat/FeatureFiles/bookValidation.feature",
glue={"classpath:com/test/APIAutomation/OneDat/StepDefinitions"},
monochrome=true)

public class AddBookRunner extends AbstractTestNGCucumberTests {

}
