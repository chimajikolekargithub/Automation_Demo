package com.restcurdoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	@Test
	public void testupdate()
	{
		
JSONObject jsonobject=new JSONObject();
		
		jsonobject.put("Name", "Keshav");
		
		jsonobject.put("Job", "Team lead");
		
		
		RestAssured.baseURI="https://reqres.in/api/users/107";
		RestAssured.given().header("Content-type","Application/json").contentType(ContentType.JSON)
		.body(jsonobject.toJSONString()).when().put()
		.then().statusCode(200).log().all();
		
		
		
	}

}
