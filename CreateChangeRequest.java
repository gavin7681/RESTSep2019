package day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateChangeRequest {
	
	@Test
	public void createCR() {
		
		// End Point
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/change_request";
		
		// Authorization
		AuthenticationScheme basic = RestAssured.basic("admin", "7QSEbbY9Hnqb");
		RestAssured.authentication = basic;
		
		// Post the request
		Response post = RestAssured
				.given()
				.contentType(ContentType.JSON)	
				.body("{\"description\" : \"Babu\"}")
				.accept(ContentType.XML)
				.post();
		
		// response print
		post.prettyPrint();
		
		// convert to xml, field, print
		XmlPath xmlPath = post.xmlPath();
		String description = xmlPath.get("response.result.description");
		System.out.println(description);

		
		
		
		
		
		
	}

}
