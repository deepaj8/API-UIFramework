package com.test.APIAutomation.OneDat.StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.test.APIAutomation.OneDat.Pojo.GetCourse;
import com.test.API_UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class CoursesValidation_StepDefinitions extends testBase {
	RequestSpecification res;
	GetCourse gc;
	
	@Given("access the coursesapi with accesstoken")
	public void access_the_coursesapi_with_accesstoken() throws IOException {
		res=given().spec(requestSpecWithAccessToken());
	}
	@When("user calls coursesapi {string} with get request")
	public void user_calls_coursesapi_with_get_request(String resource) {
		gc=res.expect().defaultParser(Parser.JSON).when()
		.get(getResourcePath(resource)).as(GetCourse.class);
	}
	@Then("the getInstructor in response body is {string}")
	public void the_getInstructor_in_response_body_is(String expectedName) {
		String actualName=gc.getInstructor();
		assertEquals(actualName,expectedName);
	}

}
