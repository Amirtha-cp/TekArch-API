
package com.Automation.RequestPOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"userid",
"id"
})

public class DeleteUserRequestPOJO {

	@JsonProperty("userid")
	private String userid;
	@JsonProperty("id")
	private String id;
	public DeleteUserRequestPOJO(String userid, String id)
	{
		this.userid = userid;
		this.id = id;
	}
	@JsonProperty("userid")
	public String getUserid() {
	return userid;
	}
	
	@JsonProperty("userid")
	public void setUserid(String userid) {
	this.userid = userid;
	}
	
	@JsonProperty("id")
	public String getId() {
	return id;
	}
	
	@JsonProperty("id")
	public void setId(String id) {
	this.id = id;
	}

}