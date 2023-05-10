package com.Auth2Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AuthonticationAuth2 {
	
	static String access_token="A21AAKsEQfWrOiGro947tK9x1ihfrSxQNuVH0nJwIFUz-SoARflGZ2vByAIVdZ2dfGqVqym0DN3dB7_V2ZlJJoTO7mIkFr5XA";
	@Test
	public void GetAccessToken()
	{
		
		String Clientid=
		"ARYc0xO3hi1KOfk0A5peGFTVzAizm4iwZuJvqNNmkzLyf9eT57szNaf1Zwk6Amyw14yt_uBFTxkT8Kek";

		String secretid =

		"EA6ttIPp0AjWGKrwFAfaoGPsLbTquJ4mYVY1ysDep52aeHYqjoD9LVsvElI42Y8PT-eakMOp_fmRavxX";
		
	 String access_token=
	"A21AAKsEQfWrOiGro947tK9x1ihfrSxQNuVH0nJwIFUz-SoARflGZ2vByAIVdZ2dfGqVqym0DN3dB7_V2ZlJJoTO7mIkFr5XA";	
		//https://api-m.sandbox.paypal.com/v1/oauth2/token
		RequestSpecification rsp=RestAssured.given();
		rsp.baseUri("https://api-m.sandbox.paypal.com");
		rsp.basePath("/v1/oauth2/token");
		
		//Basic Authorisation
	Response response=	rsp.auth().preemptive().basic( Clientid,secretid).param("grant_type", "client_credentials").post();
		
		
		response.prettyPrint();
		
		System.out.println("Resonse code:"+response.statusCode());
		System.out.println("Status Line:"+response.statusLine());
		
		//validate response code
		Assert.assertEquals(response.statusCode(), 200,"check for the response code");
		
		//get acces token
		response.getBody().path(access_token);
		System.out.println("Getting the accesss token:="+access_token);
		
		
		
		
	}
	
	@Test(dependsOnMethods = "GetAccessToken")
	public void Listinvoice()
	{
	
	Response res=	RestAssured.given().auth().oauth2(access_token).queryParam("page", "3")
		.queryParam("total_count_required", "true")
		.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
	System.out.println("\n---------------------List invoice----------------");
	
	res.prettyPrint();
	
	System.out.println("Resonse code:"+res.statusCode());
	System.out.println("Status Line:"+res.statusLine());

	
	//validate response code
			Assert.assertEquals(res.statusCode(), 200,"check for the response code");
			
	}

}
