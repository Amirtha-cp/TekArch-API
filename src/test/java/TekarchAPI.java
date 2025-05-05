import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TekarchAPI {
	public String token = null;
	@Test(priority = 1)
	public void loginTest() {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
		
		Response res = RestAssured.given().header("Content-Type", "application/json").when().body("{\"username\": \"feb2025.amritha@tekarch.com\", \"password\": \"Admin123\"}").post("login");
		
		res.prettyPeek();
		
		token = res.body().jsonPath().getString("[0].token");
		
		
	}
	@Test (dependsOnMethods = "loginTest")
	public void getDatafromTeckarch () {
//		Response res = RestAssured.given().contentType(ContentType.JSON).header("token", token).when().get("getdata");
		Response res = RestAssured.given().header("token", token).when().get("getdata");
		res.prettyPeek();
		}

}
