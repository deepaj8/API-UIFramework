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
import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.test.APIAutomation.OneDat.Resources.ApiResources;
import com.test.APIAutomation.OneDat.Resources.TestBuild;
import com.test.UIAutomation.OneDat.ExcelUtility.ExcelReader;
import com.test.UIAutomation.OneDat.Utility.CommonFunctions;

public class StepDefinition extends CommonFunctions {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestBuild data=new TestBuild();
	static String place_id;
	static String id;
	
	@Given("Add payload with {string} {string} {string}")
	public void add_payload_with(String name, String language, String address) throws IOException {
		 res=given().spec(requestSpecForJsonWithQueryParams())
					.body(data.addPlacePayload(name,language,address));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		ApiResources resourceApi=ApiResources.valueOf(resource);
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		{
	   response=res.when().post(resourceApi.getResource());
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			 response=res.when().get(resourceApi.getResource());	
		}
	}
	
	@Then("the Api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}
	
	@And("{string} in response body is {string}")
	public void is_response_body_is(String key, String expected) {
		assertEquals(getStringFromJson(response,key),expected);
	}
	
	@Then("verify expected name in {string} is {string} using {string}")
	public void verify_expected_name_using(String apis,String expectedName, String resource) throws IOException {
		if(apis.equalsIgnoreCase("places"))
		{
		place_id=getStringFromJson(response,"place_id");
		 res=given().spec(requestSpecForJsonWithQueryParams()).queryParam("place_id",place_id);
		 user_calls_with_http_request(resource,"GET");
		  String actualName=getStringFromJson(response,"name");
		  assertEquals(actualName,expectedName); 
		}
		else if(apis.equalsIgnoreCase("books"))
		{
			id=getStringFromJson(response,"ID");
			res=given().spec(requestSpecForJSON()).queryParam("ID",id);
			user_calls_with_http_request(resource,"GET");
			String actualName=getStringFromJson(response,"[0].book_name");
			  assertEquals(actualName,expectedName); 
		}
	}
	
    @Given("Delete payload for {string}")
    public void delete_payload_for(String apis) throws IOException {
		if(apis.equalsIgnoreCase("places"))
		{
    	res =given().spec(requestSpecForJsonWithQueryParams()).body(data.deleteAPIPayload(place_id));
		}
		else if(apis.equalsIgnoreCase("books"))
		{
			res =given().spec(requestSpecForJSON()).body(data.deleteBookPayLoad(id));
		}
    }
    
    @Given("Add book payload with {string} {string} {int} {string}")
    public void add_book_payload_with(String name, String isbn, Integer aisle, String author) throws IOException {
    	
    	res=given().spec(requestSpecForJSON())
				.body(data.addBookPayLoad(name, isbn,aisle,author));
    }

    @Given("Add book payload with {string} {int}")
    public void add_book_payload_with(String sheetname,Integer testcaseid) throws FilloException, IOException
    {
    	ExcelReader er=new ExcelReader();
		HashMap<String,String> hm=er.getDataFromRow("Library",sheetname,testcaseid);
		String name=hm.get("name");
		String isbn=hm.get("isbn");
		Integer aisle=Integer.valueOf(hm.get("aisle"));
		String author=hm.get("author");
		res=given().spec(requestSpecForJSON())
				.body(data.addBookPayLoad(name, isbn,aisle,author));	
    }

 
    @And("delete the book with {string} resource")
    public void delete_the_book_with_resource(String resource) throws IOException
    {
    	id=getStringFromJson(response,"ID");
    	res =given().spec(requestSpecForJSON()).body(data.deleteBookPayLoad(id));
    	ApiResources resourceApi=ApiResources.valueOf(resource);
    	res.when().post(resourceApi.getResource());
    }

}
