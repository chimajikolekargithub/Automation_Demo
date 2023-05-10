package com.session05;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ValidateResponseHeader {
	@Test
	public void testsingleuser()
	{
		
		//"https://reqres.in/api/users/2
		//Get request specification
		
	RequestSpecification reqspe =given();
	
	//specify base uri
	
	reqspe.baseUri("https://reqres.in");
	reqspe.basePath("/api/users/2");
	
	//create get request
	Response resp=reqspe.get();
	
	//Validat response header
String contenttype=	resp.header("Content-Type");

	System.out.println("Content type value="+contenttype);
	
	
	String connection =resp.getHeader("Connection");
	
	System.out.println(connection);
	
	//Iterate the headers list key and value
	Headers headerslist=resp.getHeaders();
	
	for(Header header:headerslist)
	{
		
		System.out.println("Key:"+ header.getName() +"value:"+header.getValue());
	}
	
	//Validate header content
	
	Assert.assertEquals(contenttype,"application/json; charset=utf=8","Header conntent type mimached" );
	
	
	}

}
