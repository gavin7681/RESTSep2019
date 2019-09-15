package day1;

import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import day2.BaseRequest;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncident extends BaseRequest{
	
	@Test
	public void createIncident() {
		
		// Post the request
		Response post = rSpec
				.contentType(ContentType.JSON)	
				.body("{\"short_description\" : \"Rest Assured created data \"}")
				.accept(ContentType.XML)
				.post();
		
		// response print
		post.prettyPrint();
		
		// convert to xml, field, print
		XmlPath xmlPath = post.xmlPath();
		sys_id = xmlPath.get("response.result.sys_id");
		System.out.println(sys_id);
		
		
		
		
		
		
		
	}

}
