package RestAssuredAPItest.RestAssuredAPItest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class FirstGetRequest {
	
	@Test
	public void getFirstreqt1()
	{
		
		
		Response resp=RestAssured.get("https://reqres.in/api/user?page=2");
		
		
		System.out.println("Response code="+resp.getStatusCode());
		

		System.out.println("Response Body="+resp.getBody().asString());
		

		System.out.println("Response time="+resp.getTime());


		System.out.println("Response header="+resp.getHeader("Content-Type"));
		
		
		//Validate the response
		
		int expectedstatuscode=200;
		int actualstatuscode=resp.getStatusCode();
		
		Assert.assertEquals(expectedstatuscode, actualstatuscode);
	}
	
	@Test
	public void test002()
	{
		baseURI="https://reqres.in/api/user?page=2";
		given().
		queryParam("page", "2").get().then().statusCode(200);
		
		
		
	}

}
