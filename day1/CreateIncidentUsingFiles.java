package day1;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncidentUsingFiles {
	
	@DataProvider(name="Files",parallel=true)
	public String[] getFileNames() {
		String[] fileNames = new String[2];
		fileNames[0] = "./data1.json";
		fileNames[1] = "./data2.json";
		return fileNames;
	}
	
	@Test(dataProvider="Files")
	public void createIncident(String fileNames) {		
		File file = new File(fileNames);		
		// End Point
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/incident";		
		// Authorization
		AuthenticationScheme basic = RestAssured.basic("admin", "7QSEbbY9Hnqb");
		RestAssured.authentication = basic;
				// Post the request
		Response post = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)	
				.body(file)
				.accept(ContentType.XML)
				.post();
		
		// response print
		post.prettyPrint();
		
		// convert to xml, field, print
		XmlPath xmlPath = post.xmlPath();
		String short_description = xmlPath.get("response.result.short_description");
		System.out.println(short_description);
		
		
		
		
		
		
		
	}

}
