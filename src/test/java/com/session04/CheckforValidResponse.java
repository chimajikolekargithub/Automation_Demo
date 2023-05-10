package com.session04;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CheckforValidResponse {
	
	
	
	@Test(enabled = false)
	public void getSingleUser()
	{
		//specify the base url
		baseURI="https://reqres.in/api/users/19";
		
		//Get request specification of the request
		                          
	RequestSpecification reqspe	= given();
		
	//call the get method
	
	Response response=reqspe.get();
	//Get response code
	
//	int Statuscode=response.getStatusCode();
	//Validate the response
	
	String statusline=response.getStatusLine();
	
//	Assert.assertEquals(Statuscode/*Actual status code*/, 200/*expected status code*/,"Correct status code");
	
	Assert.assertEquals(statusline, "HTTP/1.1 200 OK","incorrect statusline");
	
	//validatable response
	
	
ValidatableResponse validateresp=response.then();

validateresp.statusCode(200);
System.out.println("Second validation");

//Statusline
validateresp.statusLine("HTTP/1.1 200 OK");


	
	}
	@Test
	public void bddstylecode()
	{
		//"https://reqres.in/api/users/2";
		given()
		.when()
		   .get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
	}
	

}
