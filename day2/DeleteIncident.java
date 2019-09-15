package day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest{
	
	@Test(dependsOnMethods="day1.CreateIncident.createIncident")
	public void deleteIncident() {
		
		
		// Send a request (Ctrl+2 -> L)
		Response response = 
				rSpec
				.delete("/"+sys_id);
		
		// Print
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
	}

}
