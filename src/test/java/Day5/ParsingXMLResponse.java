package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class ParsingXMLResponse {
	
	@Test
	void testXMLResponse()
	{
		
		
		//Approach1
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"))     // this is the xpath for particular module
			.body("TravelerinformationResponse.travelers.Travelerinformation[1].name", equalTo("AS"));
	}
	
	
	

}
