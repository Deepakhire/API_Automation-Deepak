package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ParsingXMLResponse2 {
	
	@Test
	void testXMLResponse()
	{
		
		
		//Approach2
		
		
		Response res =
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
		
		String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");
		
		String travelName=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
		Assert.assertEquals(travelName, "AS");
		
		
	}

}
