package com.sewssion09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {
	
	@Test
	public void bearerTokentest()
	{
		//https://gorest.co.in/public/v2/users
		//create specification
		RequestSpecification requestspec=RestAssured.given();
		//Add url
		requestspec.baseUri("https://gorest.co.in");
		 requestspec.basePath("/public/v2/users");
		 
		 
//		 {
//			 "name":"chimaji",
//			 "gender":"male",
//			 "email":"chimajikolekar@gmail.com",
//			 "status":"Active"
//			 }
//		 //create objec of the json
		 
		 JSONObject payload=new JSONObject();
		 
		 payload.put("name", "chimaji1234");
		 payload.put("gender", "male");
		 payload.put("email", "chimajikolekar223@gmail.com");
		 payload.put("status", "Active");
		 
		 String bearetoken="Bearer 6f20de5c624c01a904b7fe0293cf15ecca082a034482ea4afd121d7e6f1f77c2";
		 requestspec.headers("Authorization",bearetoken).
		 contentType(ContentType.JSON)
		 .body(payload.toJSONString());
		 
		 Response responsebody=requestspec.post();
		 
		 //Assert the  resonse
		 
		 Assert.assertEquals(responsebody.statusCode()/*actual*/, 201,"check for the status code");
		 
		 //print the Statusline
		 
		 System.out.println("Response statuse:"+responsebody.statusLine());
		 System.out.println("Response Body:"+responsebody.body().asString());
		
		
		
	}

}
