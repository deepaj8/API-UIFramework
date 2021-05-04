package com.test.APIAutomation.OneDat.Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import com.test.UIAutomation.OneDat.Utility.Constants;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecifications() throws IOException {
		if(req==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("APILogReports.txt"));
		req =new RequestSpecBuilder().setBaseUri(getURI("baseUri")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	
	public RequestSpecification requestSpecForLibrary() throws IOException {
		if(req==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("logReports.txt"));
		req =new RequestSpecBuilder().setBaseUri(getURI("baseUri"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	
	public static String getURI(String key) throws IOException
	{
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(Constants.CONFIG_FILE_PATH);
		pro.load(fis);
		return pro.getProperty(key);
		
		
	}
	public String getJsonPath(Response response,String key)
	{
		String s=response.asString();
		JsonPath js=new JsonPath(s);
		return js.get(key).toString();
	}
	
}
