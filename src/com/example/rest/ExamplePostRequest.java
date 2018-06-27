package com.example.rest;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExamplePostRequest {
	
	@Test
	public void testPostRequest() throws JSONException {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		RequestSpecification req=RestAssured.given();

		JSONObject jobj=new JSONObject();
		jobj.put("FirstName", "mass");
		jobj.put("LastName", "puli");
		jobj.put("UserName", "massmalli");
		jobj.put("Password", "malligadu");
		jobj.put("Email", "mallit333@gmail.com");
		
		req.header("Content-Type","application/json");
		req.body(jobj.toString());
		
		
		Response response=req.post("/register");
		
		int statuscode=response.getStatusCode();
		System.out.println("status code: ================ "+statuscode);
		
		String statusline=response.getStatusLine();
		System.out.println("satus line msg: ================== "+statusline);
		
		Assert.assertEquals(200, statuscode);
		
		String msg=response.getBody().asString();
		System.out.println("response body msg: =============== "+msg);
		
		/*JsonPath jpath=response.jsonPath();
		String city=jpath.get("city");
		Assert.assertEquals("Hyderabad", city);*/
		
		
		
		
		
		
	}
	

}
