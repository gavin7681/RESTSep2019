package day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetChangeRequests extends BaseRequest{
	
	@Test(groups="oauth")
	public void getAllChangeRequests() {
		
		// Send a request (Ctrl+2 -> L)
		Response response = RestAssured
				.given()
				.log()
				.all()
				.get();
		
		// Print
		//response.prettyPrint();
		
		JsonPath jsonResponse = response.jsonPath();
		List<String> allCR = jsonResponse.getList("result.sys_id");
		int random = (int)(Math.random()*allCR.size());
		System.out.println(random);
		System.out.println(allCR.get(random)); 
		sys_id = allCR.get(random);
		
	}

}





