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
import com.test.API_UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;

public class BookValidation_StepDefinitions extends testBase {
	
	RequestSpecification res;
	TestBuild data=new TestBuild();
	static String id;
	
	 @Given("Add book payload with {string} {string} {int} {string}")
	    public void add_book_payload_with(String name, String isbn, Integer aisle, String author) throws IOException {
	    	
	    	res=given().spec(requestSpecForJSON())
					.body(data.addBookPayLoad(name, isbn,aisle,author));
	    }
	 
	 @When("user calls bookApi {string} with {string} http request")
		public void user_calls_bookApi_with_http_request(String resource, String method) {
		if(method.equalsIgnoreCase("POST"))
			{
		   response=res.when().post(getResourcePath(resource));
			}
			else if(method.equalsIgnoreCase("GET"))
			{
				 response=res.when().get(getResourcePath(resource));	
			}
		}
	 @Then("the bookApi call is success with status code {int}")
		public void the_bookApi_call_is_success_with_status_code(Integer expCode) {
		 response.then().spec(jsonResponseSpecForStatusCode(expCode)).extract();
		}
	 @And("verify expected name in books is {string} using {string}")
		public void verify_expected_name_in_books_using(String expectedName, String resource) throws IOException {
			
				id=getStringFromJson(response,"ID");
				res=given().spec(requestSpecForJSON()).queryParam("ID",id);
				 user_calls_bookApi_with_http_request(resource,"GET");
				String actualName=getStringFromJson(response,"[0].book_name");
				logMessageInToResults("Returned name in response is--"+actualName);
				  assertEquals(actualName,expectedName); 
		}
		@Given("Delete payload for books")
		public void delete_payload_for_books() throws IOException {
			res =given().spec(requestSpecForJSON()).body(data.deleteBookPayLoad(id));
		}
}

