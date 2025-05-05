package com.Automation.APITest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Automation.RequestPOJO.AddUserRequestPOJO;
import com.Automation.RequestPOJO.DeleteUserRequestPOJO;
import com.Automation.ResponsePOJO.AddUserResponsePOJO;
import com.Automation.ResponsePOJO.GetUserDataResponsePOJO;
import com.Automation.ResponsePOJO.LoginResponse;
import com.Tekarch.Base.APIServices;
import com.Tekarch.Base.BaseTest;
import com.TekarchAPI.utils.APIConstants;
import com.TekarchAPI.utils.FakerUtils;
import com.TekarchAPI.utils.TekarchProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class AddUserTest extends BaseTest{
	
	APIServices apiServiceObj;
	String userId, token, accountNo, departmentNo, salary, pincode;
	String dataId = "";
	
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
	
	@Test
	public void GetUserDataTest() {
		Response getUserResponse = apiServiceObj.getUser(token);
		System.out.println(token);
		logger.info("--------------Inside GetUserdata Test--------------");
//		String header_value = getUserResponse.getHeader(token);
//		System.out.println(header_value);
		logger.debug(getUserResponse.asPrettyString());
		AssertJUnit.assertEquals(getUserResponse.getStatusCode(), 200);
	}
	
	@Test
    public void addUserWithFakerDataTest() throws JsonProcessingException {
		accountNo = FakerUtils.generateAccountno();
		departmentNo = FakerUtils.generateDepartmentno();
		salary = FakerUtils.generateSalary();
		pincode = FakerUtils.generatePincode();
		AddUserRequestPOJO addFakeUser = new AddUserRequestPOJO(accountNo, departmentNo,salary,pincode);
		ObjectMapper om = new ObjectMapper();
		String addUserpayload = om.writeValueAsString(addFakeUser);
        System.out.println("\n Fake user payload " + addUserpayload);
        Response response =  apiServiceObj.adduser(addFakeUser);
        System.out.println(response.getStatusCode());
    	System.out.println(token);
        AddUserResponsePOJO responsePOJO = om.readValue(response.getBody().asString(),AddUserResponsePOJO.class);
        System.out.println(responsePOJO.getStatus());
 }
	
	@Test
	public void testaddUserusingJsonFile() throws JsonMappingException, JsonProcessingException {
		
	}
	@Test
	public void verifyAddUserdataTest() throws JsonMappingException, JsonProcessingException {
		
		Response getUserResponse = apiServiceObj.getUser(token);
		ObjectMapper om = new ObjectMapper();
		List<GetUserDataResponsePOJO> getUserListsfromGetdata = om.readValue(getUserResponse.getBody().asString(),
				new TypeReference <List<GetUserDataResponsePOJO>> () {});
		
		GetUserDataResponsePOJO getAddedUserResponse = getAddedUserdatafromList(userId, accountNo,getUserListsfromGetdata);
		dataId = getAddedUserResponse.getId();
		AssertJUnit.assertEquals(getAddedUserResponse.getDepartmentno(),departmentNo );
		AssertJUnit.assertEquals(getAddedUserResponse.getSalary(),salary );
		AssertJUnit.assertEquals(getAddedUserResponse.getPincode(),pincode );
	}
@Test	(dependsOnMethods = "addUserWithFakerDataTest")
public void deleteUserdataTest() throws JsonMappingException, JsonProcessingException {
	DeleteUserRequestPOJO deleteUser = new DeleteUserRequestPOJO(userId, dataId);
	ObjectMapper om = new ObjectMapper();
	String deleteUserpayload = om.writeValueAsString(deleteUser);
	System.out.println(deleteUserpayload);
		Response getDeleteResponse = apiServiceObj.deleteUser(deleteUser, token);
		System.out.println(getDeleteResponse.asPrettyString());
		System.out.println(getDeleteResponse.getStatusCode());
		System.out.println(getDeleteResponse.getStatusCode());
		 

//		List<GetUserDataResponsePOJO> getUserListsfromGetdata = om.readValue(getUserResponse.getBody().asString(),
//				new TypeReference <List<GetUserDataResponsePOJO>> () {});
//		
//		GetUserDataResponsePOJO getAddedUserResponse = getAddedUserdatafromList(userId, accountNo,getUserListsfromGetdata);
//		
//		assertEquals(getAddedUserResponse.getDepartmentno(),departmentNo );
//		assertEquals(getAddedUserResponse.getSalary(),salary );
//		assertEquals(getAddedUserResponse.getPincode(),pincode );
	}
	
	
	public GetUserDataResponsePOJO getAddedUserdatafromList(String userId, String accountNo, List<GetUserDataResponsePOJO> getUserListsfromGetdata ) {
		
		for (GetUserDataResponsePOJO getUserResponse: getUserListsfromGetdata) {
			if (getUserResponse.getAccountno().equals(accountNo) && getUserResponse.getUserid().equals(userId)) {
				return getUserResponse;
			}
		}
		return null;
	}

}
