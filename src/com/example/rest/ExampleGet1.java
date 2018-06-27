package com.example.rest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExampleGet1 {
	
	@Test
	public void testGetMethod() {
		
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification req=RestAssured.given();
		Response response=req.request(Method.GET, "/api/users");
		 Headers header=response.getHeaders();
		 
		 Map<String,String> m=new HashMap();
		 for(Header h:header) {
			 m.put(h.getName(), h.getValue());
		 }
	
		 System.out.println(m);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(200, statuscode);
		
		System.out.println(" Status code ============ "+statuscode);
		
		String bodymsg=response.getBody().asString();
		
		System.out.println(" response body: ================ "+bodymsg);
		System.out.println(response.getStatusLine());
		System.out.println("================================================ ");
		System.out.println(response.getBody());
		
		System.out.println("************************************");
		
		JsonPath jsonpath=response.jsonPath();
		String city=jsonpath.get("city");
		
		System.out.println("city : ================ "+city);
		Assert.assertEquals("Hyderabad", city);
		
		
	}
	

}
