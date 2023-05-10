package com.restcurdoperation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Curdoperation {
	
	@Test
	public void getFirstreqt1()
	{
		
		
		Response resp=get("https://reqres.in/api/user?page=2");
		
		
		System.out.println("Response code="+resp.getStatusCode());
		

		System.out.println("Response Body="+resp.getBody().asString());
		

		System.out.println("Response time="+resp.getTime());


		System.out.println("Response header="+resp.getHeader("Content-Type"));
		
		
		//Validate the response
		
		int expectedstatuscode=200;
		int actualstatuscode=resp.getStatusCode();
		
		Assert.assertEquals(expectedstatuscode, actualstatuscode);
	}

	
	//validation
	
	@Test
	public void test01()
	{
		//given, when, then.
		
		baseURI="https://reqres.in/api/user";
	
		given().
		queryParam("page", "2").
		when().get().
		then().statusCode(200);
		
		
	}
	
	
	
}
