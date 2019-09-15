package day2;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public static String sys_id;
	public static RequestSpecification rSpec;
	
	@BeforeSuite(groups="basic")
	public void initializeBasic() {
		// End Point URL
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/change_request";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "7QSEbbY9Hnqb");
		
		rSpec = RestAssured.given().log().all();
			
	}
	
	@BeforeSuite(groups="oauth")
	public void initializeOauth() {
		// End Point URL
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/change_request";
		
		// Authorization
		RestAssured.authentication = RestAssured.oauth2("");
		
		rSpec = RestAssured.given().log().all();
			
	}

}
