package day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncident {
	
	@Test(groups="basic")
	public void createIncident() {
		
		// End Point
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/incident";
		
		// Authorization
		AuthenticationScheme basic = RestAssured.basic("admin", "7QSEbbY9Hnqb");
		RestAssured.authentication = basic;
		
/*		AuthenticationScheme basic = RestAssured.preemptive().basic("testleaf0123@gmail.com", "api-key");
		RestAssured.authentication = basic;
		
		RestAssured.authentication = RestAssured.oauth2("");*/
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		headers.put("accept", "application/xml");
		
		
		// Post the request
		Response post = RestAssured
				.given()
				/*.cookies(cookies)*/
/*				.contentType(ContentType.JSON)	
				.accept(ContentType.XML)
*/				//.header(new Header("content-type", "application/json"))
				.headers(headers)
				.body("{\"short_description\" : \"Rest Assured created data \"}")
				.post();
		
		// response print
		post.prettyPrint();
		
		// response header
		/*Headers headers2 = post.getHeaders();
		for (Header header : headers2) {
			System.out.println(header.getName());
			System.out.println(header.getValue());
		}
		*/
		System.out.println("******************************");
		Map<String, String> cookies = post.getCookies();
		for (Entry<String, String> cookie : cookies.entrySet()) {
			System.out.println(cookie.getKey());
			System.out.println(cookie.getValue());
		}
		System.out.println("******************************");

		// convert to xml, field, print
		XmlPath xmlPath = post.xmlPath();
		String number = xmlPath.get("response.result.sys_id");
		System.out.println(number);
		
		
		
		
		
		
		
	}

}
