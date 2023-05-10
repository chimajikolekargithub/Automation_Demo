package com.restcurdoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {

	@Test
	public void testdeleterequest()
	{
		

		RestAssured.baseURI="https://reqres.in/api/users/107";
		RestAssured.given().
	when().
	      delete()
	.then().
	    statusCode(204).
	    log().all();
		
		
	}
}
