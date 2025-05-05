package com.Tekarch.Base;

import java.io.File;
import java.util.HashMap;

import com.Automation.RequestPOJO.AddUserRequestPOJO;
import com.Automation.RequestPOJO.DeleteUserRequestPOJO;
import com.Automation.RequestPOJO.LoginRequestPOJO;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIServices extends BaseTest{
	
	RequestSpecification requestSpec;
	static String token = "";
	
	
	public APIServices() {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
		requestSpec = RestAssured.given().contentType("application/json");
		
	}

	public Response login(String username, String password) throws Exception {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        LoginRequestPOJO loginData = new LoginRequestPOJO();
        loginData.setUsername(username);
        loginData.setPassword(password);
        System.out.println(loginData.toString());
       Response response = requestSpec
                    .body(om.writeValueAsString(loginData))
                .when()
                    .post("login"); 
       
		token = response.body().jsonPath().getString("[0].token");
		return response;		
	}
	public Response getUser(String token) {
		    Response response = RestAssured
		        .given()
		            .baseUri("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/")
		            .contentType("application/json")
		            .header("token", token)
		            .get("getdata");
	
		return response;
	}
	public Response adduser(AddUserRequestPOJO addUser) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		Response response = requestSpec.header("token",token).body(om.writeValueAsString(addUser)).post("addData");
		
		return response;
	}
	
	public Response deleteUser(DeleteUserRequestPOJO deleteUser, String token) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		Response response = RestAssured
		        .given()
	            .baseUri("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/")
	            .contentType("application/json")
	            .header("token", token)
	            .body(om.writeValueAsString(deleteUser))
	            .delete("deleteData");
		return response;
	}
	public static HashMap<String, String> getHeaders(boolean includeToken) {
		HashMap<String, String> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");

	    if (includeToken) {
	        headers.put("token", token); // or access token from somewhere
	    }
	    System.out.println(token);
	    return headers;
	}

}
