package com.Automation.ResponsePOJO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"token",
"userid"
})

public class LoginResponse {

	@JsonProperty("token")
	private String token;
	@JsonProperty("userid")
	private String userid;
	
	public LoginResponse() {
	}
	
	@JsonProperty("token")
	public String getToken() {
	return token;
	}

	@JsonProperty("token")
	public void setToken(String token) {
	this.token = token;
	}
	
	@JsonProperty("userid")
	public String getUserid() {
	return userid;
	}

	@JsonProperty("userid")
	public void setUserid(String userid) {
	this.userid = userid;
	}

}
