package com.restcurdoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchRequest {
	
	@Test
	public void testpatch()
	{
	
JSONObject jsonobject=new JSONObject();
		
		jsonobject.put("Name", "Govind");
		
		jsonobject.put("Job", "QA Lead");
		
		
		RestAssured.baseURI="https://reqres.in/api/users/107";
		RestAssured.given().header("Content-type","Application/json").
		contentType(ContentType.JSON)
		.body(jsonobject.toJSONString()).
	when().
	      patch()
	.then().
	    statusCode(200).
	    log().all();
		
		

		
	}

}
