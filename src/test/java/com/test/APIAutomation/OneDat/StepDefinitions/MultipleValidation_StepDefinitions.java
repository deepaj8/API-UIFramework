package com.test.APIAutomation.OneDat.StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.test.APIAutomation.OneDat.Resources.TestBuild;
import com.test.API_UIAutomation.OneDat.ExcelUtility.ExcelReader;
import com.test.API_UIAutomation.OneDat.TestBase.testBase;


public class MultipleValidation_StepDefinitions extends testBase {
	
	RequestSpecification res;
	TestBuild data=new TestBuild();
	static String id;
	
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
			logMessageInToResults("Add payload with--"+name+" "+isbn+" "+aisle+" "+author);
	    }
	 
	 @When("user calls multiple bookApi {string} with {string} http request")
		public void user_calls_multiple_bookApi_with_http_request(String resource, String method) {
		   response=res.when().post(getResourcePath(resource));
		}
	 
	 @And("delete the book with {string} resource")
	    public void delete_the_book_with_resource(String resource) throws IOException
	    {
	    	id=getStringFromJson(response,"ID");
	    	res =given().spec(requestSpecForJSON()).body(data.deleteBookPayLoad(id));
	    	res.when().post(getResourcePath(resource));
	    }


}
