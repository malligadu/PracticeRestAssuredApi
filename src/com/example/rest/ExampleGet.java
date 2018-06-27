package com.example.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExampleGet {
	
	@Test
	public void getMethodTest() {
		
		//base uri
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
	RequestSpecification reqspe=RestAssured.given();
	
	 // requestspecification send to the server
	
	 //Response response=reqspe.request(Method.GET);
	
	Response response=reqspe.request(Method.GET, "/Hyderabad");
	
     int status=response.getStatusCode();
     System.out.println("status code: ======== "+status);
     
		Assert.assertEquals(200, status);
		
		String bodymsg=response.getBody().asString();
		System.out.println("response body msg: ============= "+bodymsg);
		
		
	}

}
