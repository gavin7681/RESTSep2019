package day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncident {
	
	@Test
	public void createIncident() {
		
		// End Point
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/incident";
		
		// Authorization
		AuthenticationScheme basic = RestAssured.basic("admin", "7QSEbbY9Hnqb");
		RestAssured.authentication = basic;
		
		// Post the request
		Response post = RestAssured
				.given()
				.contentType(ContentType.JSON)	
				.body("{\"short_description\" : \"Rest Assured created data \"}")
				.accept(ContentType.XML)
				.post();
		
		// response print
		post.prettyPrint();
		
		// convert to xml, field, print
		XmlPath xmlPath = post.xmlPath();
		String number = xmlPath.get("response.result.number");
		System.out.println(number);
		
		
		
		
		
		
		
	}

}
