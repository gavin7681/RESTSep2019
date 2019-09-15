package day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteCR extends BaseRequest{
	
	@Test(dependsOnMethods="day1.GetChangeRequests.getAllChangeRequests")
	public void deleteIncident() {
		
		
		// Send a request (Ctrl+2 -> L)
		Response response = 
				rSpec
				.auth()
				.oauth2("")
				.delete("/"+sys_id);
		
		// Print
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
	}

}
