package day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIncidentsXml {
	
	@Test
	public void getAllIncidents() {
		
		// End Point URL
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "7QSEbbY9Hnqb");
		
		// Create Parameter for Query
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("priority", "1");
		parametersMap.put("severity", "1");
		parametersMap.put("sysparm_fields", "sys_id,number,priority");

		
		// Send a request (Ctrl+2 -> L)
		Response response = 
				RestAssured
				.given()
				.accept(ContentType.XML)
				.params(parametersMap) 
				.get();
		
		// Print
		response.prettyPrint();
		
		int statusCode = response.statusCode();
		String statusLine = response.statusLine();
		System.out.println(statusCode + " - "+statusLine);
		
		long time = response.getTime();
		System.out.println(time);
		
		String contentType = response.getContentType();
		System.out.println(contentType);
		
		/*JsonPath jsonResponse = response.jsonPath();
		List<String> allIncidentNumbers = jsonResponse.getList("result.number");
		System.out.println(allIncidentNumbers.size());
		for (String eachIncident : allIncidentNumbers) {
			System.out.println(eachIncident);
		}*/
		
		
	}

}
