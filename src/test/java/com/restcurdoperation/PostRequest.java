package com.restcurdoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void testpost()
	{
		
		JSONObject jsonobject=new JSONObject();
		
		jsonobject.put("Name", "Chimaji");
		
		jsonobject.put("Job", "QA");
		
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-type","Application/json").contentType(ContentType.JSON)
		.body(jsonobject.toJSONString()).when().post()
		.then().statusCode(201).log().all();
		
	}

}
