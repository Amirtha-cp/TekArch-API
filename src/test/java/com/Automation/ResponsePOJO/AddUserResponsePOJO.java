package com.Automation.ResponsePOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AddUserResponsePOJO {
	@JsonProperty("status")
	private String status;
	public AddUserResponsePOJO() { }
	
	public AddUserResponsePOJO(String status) {
		this.status = status;
	}
	
		@JsonProperty("status")
		public String getStatus() {
		return status;
		}

		@JsonProperty("token")
		public void setStatus(String status) {
		this.status = status;
		}

	}

