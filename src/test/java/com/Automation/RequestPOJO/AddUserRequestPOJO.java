package com.Automation.RequestPOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AddUserRequestPOJO {
//{
//    "accountno": "TA-Amirthap",
//    "departmentno": "2",
//    "salary": "50000",
//    "pincode": "111111"   
//}
	
	@JsonProperty("accountno")
	private String accountno;
	@JsonProperty("departmentno")
	private String departmentno;
	@JsonProperty("salary")
	private String salary;
	@JsonProperty("pincode")
	private String pincode;
	
	
	public AddUserRequestPOJO() { }
	
	public AddUserRequestPOJO(String accountno, String departmentno, String salary, String pincode  ) {
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
		
	}
	
//	Getters and Setters method 
	@JsonProperty("accountno")
	public String getAccountno() {
		
		return accountno;
	}
	@JsonProperty("departmentno")
	public String getDepartmentno() {
		
		return departmentno;
	}
	@JsonProperty("salary")
	public String getSalary() {
		
		return salary;
	}
	@JsonProperty("pincode")
	public String getPincode() {
		
		return pincode;
	}
	@JsonProperty("accountno")
	public void setAccountno(String accountno) {
		
		this.accountno =  accountno;
	}
	@JsonProperty("departmentno")
	public void setDepartmentno(String departmentno) {
		
		this.departmentno = departmentno;
	}
	@JsonProperty("salary")
	public void setSalary(String salary) {
		
		this.salary = salary;
	}
	@JsonProperty("pincode")
	public void setPincode(String pincode) {
		
		this.pincode = pincode;
	}
	
}
