package com.test.APIAutomation.OneDat.StepDefinitions;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import com.test.APIAutomation.OneDat.Resources.TestBuild;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;

public class PlaceValidation_StepDefinitions extends CommonFunctions {
	
	RequestSpecification res;
	TestBuild data=new TestBuild();
	static String place_id;
	
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		res=given().spec(requestSpecForJsonWithQueryParams())
				.body(data.addPlacePayload(name,language,address));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		if(method.equalsIgnoreCase("POST"))
		{
	   response=res.when().post(getResourcePath(resource));
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			 response=res.when().get(getResourcePath(resource));	
		}
	}
	@Then("the placeApi call is success with status code {int}")
	public void the_placeApi_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}
	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String expected) {
		assertEquals(getStringFromJson(response,key),expected);
	}
	@And("verify expected name in places is {string} using {string}")
	public void verify_expected_name_in_places_is_using(String expectedName, String resource) throws IOException {
		place_id=getStringFromJson(response,"place_id");
		 res=given().spec(requestSpecForJsonWithQueryParams()).queryParam("place_id",place_id);
		 user_calls_with_http_request(resource,"GET");
		  String actualName=getStringFromJson(response,"name");
		  assertEquals(actualName,expectedName);
	   
	}
	
	@Given("Delete payload for places")
	public void delete_payload_for_places() throws IOException {
		res =given().spec(requestSpecForJsonWithQueryParams()).body(data.deleteAPIPayload(place_id));
	}

}
