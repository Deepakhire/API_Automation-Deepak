package Authentication;

import org.testng.annotations.Test;

import io.restassured.internal.http.Status;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Oauth1 {
	
	
//	@Test
//	void testOauth1()
//	{
//		given()
//			.auth().oauth("consumerKey","consumerSecret","accessToken","tokenSecret")  // this is for oauth1.0 authentication
//			
//		.when()
//			.get("url")
//		
//		.then()
//			.statusCode(200)
//			.log()
//			.all();
		
		
	//}
	
	@Test
	
	void testOauth2()
	{
		given()
			.auth().oauth2("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")
		
		.when()
			.get("https://github.com/")
		
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	
	
	
	// Method-1
	
	@Test
	
	void testAPIKeyAuthentication()
	{
		
		given()
			.queryParam("appid", "key")   // appid is key
		
		.when()
			.get("url")
		
		.then()
			.statusCode(200)
			.log().all();

		
		//Method -2
		
		given()
			.queryParam("appid", "key")
			.pathParam("mypath", "   ")
			.queryParam("q", "  ")
			.queryParam("units", "   ")
			.queryParam("unt", "   ")
		
		.when()
			.get("url")
		
		.then()
			.statusCode(200)
			.log().all();
		
		
}}
	
	
	


	
	


