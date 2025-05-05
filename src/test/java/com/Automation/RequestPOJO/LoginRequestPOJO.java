package com.Automation.RequestPOJO;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class LoginRequestPOJO {
		private String username;
		private String password;
	   
		public LoginRequestPOJO() {}
	    public LoginRequestPOJO (String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    // Getters & Setters
	    
	    @JsonDeserialize
	    public String getUsername() {
	     return username; 
	    }
	    
	    @JsonDeserialize
	    public void setUsername(String username) { 
	    	this.username = username; 
	    	}
	    
	    @JsonDeserialize
	    public String getPassword() { 
	    	return password; 
	    	}
	    
	    @JsonDeserialize
	    public void setPassword(String password) { 
	    	this.password = password; 
	    	}
	}


