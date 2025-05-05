
package com.Automation.ResponsePOJO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"accountno",
"departmentno",
"salary",
"pincode",
"userid",
"id"
})

public class GetUserDataResponsePOJO {

@JsonProperty("accountno")
private String accountno;
@JsonProperty("departmentno")
private String departmentno;
@JsonProperty("salary")
private String salary;
@JsonProperty("pincode")
private String pincode;
@JsonProperty("userid")
private String userid;
@JsonProperty("id")
private String id;

@JsonProperty("accountno")
public String getAccountno() {
return accountno;
}

@JsonProperty("accountno")
public void setAccountno(String accountno) {
this.accountno = accountno;
}

@JsonProperty("departmentno")
public String getDepartmentno() {
return departmentno;
}

@JsonProperty("departmentno")
public void setDepartmentno(String departmentno) {
this.departmentno = departmentno;
}

@JsonProperty("salary")
public String getSalary() {
return salary;
}

@JsonProperty("salary")
public void setSalary(String salary) {
this.salary = salary;
}

@JsonProperty("pincode")
public String getPincode() {
return pincode;
}

@JsonProperty("pincode")
public void setPincode(String pincode) {
this.pincode = pincode;
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
