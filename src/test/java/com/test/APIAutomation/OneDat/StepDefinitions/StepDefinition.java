package com.test.APIAutomation.OneDat.StepDefinitions;

import io.cucumber.java.en.And;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.io.IOException;

import com.test.APIAutomation.OneDat.Resources.ApiResources;
import com.test.APIAutomation.OneDat.Resources.CommonUtils;
import com.test.APIAutomation.OneDat.Resources.TestBuild;

public class StepDefinition extends CommonUtils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestBuild data=new TestBuild();
	
	@Given("Add place payload")
	public void add_place_payload() throws IOException {
		 res=given().spec(requestSpecifications())
		.body(data.addPlacePayload());
	}
	
	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String resource) {
		ApiResources resourceApi=ApiResources.valueOf(resource);
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	   response=res.when().post(resourceApi.getResource()).
		then().spec(resspec).extract().response();
	}
	
	@Then("the Api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}
	
	@And("{string} in response body is {string}")
	public void is_response_body_is(String key, String expected) {
		assertEquals(getJsonPath(response,key),expected);
	}


}
