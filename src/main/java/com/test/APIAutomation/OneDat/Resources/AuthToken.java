package com.test.APIAutomation.OneDat.Resources;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.test.UIAutomation.OneDat.Utility.CommonFunctions;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class AuthToken extends CommonFunctions{
	
	/****get the code from signin url application****/
	public String getCode()
	{
		selectBrowser(loadData("browser"));
		getURL(loadData("apiUrl"));
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(loadData("userName"));
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		customWait.waitForSeconds(4);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(loadData("password"));
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
		customWait.waitForSeconds(4);
		String url=driver.getCurrentUrl();
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		driver.quit();
		return code;
	}
	
	/****Request specification to get the access token****/
	public RequestSpecification requestSpecToGetAccessToken() throws FileNotFoundException {
		return  withOutBaseUri()
				.urlEncodingEnabled(false)
				.queryParams("code",getCode())
				.queryParams("client_id",loadData("client_id"))
				.queryParams("client_secret",loadData("client_secret"))
				.queryParams("redirect_uri",loadData("redirect_uri"))
				.queryParams("grant_type",loadData("grant_type"));
	}
	
	/****get the access token from the response****/
	public String getAccessToken() throws FileNotFoundException
	{
		        response=given().spec(requestSpecToGetAccessToken())
				.when()
				.post(loadData("accesstoken_url")).then().extract().response();
			return getStringFromJson(response,"access_token");
	}

}
