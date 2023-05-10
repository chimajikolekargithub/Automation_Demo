package com.session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiKey {
	
	@Test
	public void testApikey()
	{
		
		//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		
		//b41f02043e336070e5db07c7d6d9ebcb
		//create request
		RequestSpecification rsp=RestAssured.given();
		rsp.baseUri("https://api.openweathermap.org");
		rsp.basePath("/data/2.5/weather").queryParam("q", "mumbai").
		queryParam("appid", "b41f02043e336070e5db07c7d6d9ebcb");
		Response response=rsp.get();
		
		 //Assert the  resonse
		 
		 Assert.assertEquals(response.statusCode()/*actual*/, 200,/*expected*/"check for the status code");
		 
		 //print the Statusline
		 
		 System.out.println("Response statuse:"+response.statusLine());
		 System.out.println("Response Body:"+response.body().asString());
		
		
		
	}

}
