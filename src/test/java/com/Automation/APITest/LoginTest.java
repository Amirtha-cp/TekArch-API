package com.Automation.APITest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Automation.ResponsePOJO.LoginResponse;
import com.Tekarch.Base.APIServices;
import com.Tekarch.Base.BaseTest;
import com.TekarchAPI.utils.APIConstants;
import com.TekarchAPI.utils.TekarchProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.TypeRef;

import io.restassured.response.Response;

public class LoginTest extends BaseTest{
	APIServices apiServiceObj;
	
	
	@BeforeClass
	
	public void beforeClass()
	{
		apiServiceObj = new APIServices();
	}
	@Test
	public void loginTest() throws Exception {
		Response response = apiServiceObj.login(TekarchProperties.readDatafromConfigPropertiesFile(APIConstants.API_PROPERTIES, "username"),TekarchProperties.readDatafromConfigPropertiesFile(APIConstants.API_PROPERTIES, "password"));

		ObjectMapper om = new ObjectMapper();
		List<LoginResponse> loginResponseList = om.readValue(response.getBody().asString(), 
		    new TypeReference<List<LoginResponse>>() {});
		String userid = loginResponseList.get(0).getUserid();
		String token = loginResponseList.get(0).getToken();
		logger.debug(userid.toString());
		logger.debug(token.toString());
		logger.debug(userid.toString());
		logger.debug(response.asPrettyString());
	}
	
	public void invalidLoginTest() {
		
		
	}

}
