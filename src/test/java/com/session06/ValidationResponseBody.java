package com.session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidationResponseBody {

	
	//"https://reqres.in/api/users/?pages=2"
	@Test
	 public void testresponsebody()
	 {
		//Get requestspecification reference
		 RequestSpecification reqspe=RestAssured.given();
		 
		 //specify base uri
		 
		 reqspe.baseUri("https://reqres.in/");
		 reqspe.basePath("/api/users/?pages=2");
		 
		 //Create and perform get request
		 Response resp=reqspe.get();
		 //Read response body
		 
		 ResponseBody rb=resp.getBody();
		 
//		 String rbstring=rb.asString();
//		 
//		 System.out.println("Get the responsebody"+rbstring);
//		 
//		 //check for presence george in response body
//		 
//		 Assert.assertEquals(rbstring.contains("George"),true,"check for the presence of george");
	 
	 JsonPath path=rb.jsonPath();
	 }
}
