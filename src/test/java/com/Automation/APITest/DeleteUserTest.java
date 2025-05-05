package com.Automation.APITest;

import java.util.List;

import org.testng.annotations.BeforeMethod;

import com.Automation.ResponsePOJO.LoginResponse;
import com.Tekarch.Base.APIServices;
import com.Tekarch.Base.BaseTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class DeleteUserTest extends BaseTest {

	
	APIServices apiServiceObj;
	String userId, token, accountNo, departmentNo, salary, pincode;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		apiServiceObj = new APIServices();
		Response loginResponse = apiServiceObj.login(username,password);
		ObjectMapper om = new ObjectMapper();
		logger.info("--------------Before class Login Post--------------");
//		object mapper om.readvalue maps json string to POJO class
//		object mapper om.writeValueAsString from POJO to JSON string
		List<LoginResponse> loginResponseList = om.readValue(loginResponse.getBody().asString(), 
		    new TypeReference<List<LoginResponse>>() {});
		userId = loginResponseList.get(0).getUserid();
		token = loginResponseList.get(0).getToken();
		logger.debug(userId.toString());
		logger.debug(token.toString());

	}
}
