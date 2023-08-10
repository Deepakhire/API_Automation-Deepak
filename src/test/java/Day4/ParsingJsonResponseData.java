package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
//import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.checkerframework.checker.units.qual.Length;
import org.json.JSONObject;

public class ParsingJsonResponseData {
	
	
//	@Test
//void testJsonResponse()
//	{
		////////////////////////////////////////////Approach-1/////////////////////////////////////////////////
		
//		given()
//			.contentType("CntentType.JSON")
//		.when()
//			.get("http://localhost:3000/store")
//		.then()
//			.statusCode(200)
//			.header("Content-Type","application/json; charset=utf-8")
//			.body("book[3].title", equalTo("The Lord of the Rings"));
		
		
		/////////////////////////////////////////Approach-2///////////////////////////////////////
		
		// Without using then () method
		
//		Response res = given()
//			.contentType(ContentType.JSON)
//			
//			.when()
//				.get("http://localhost:3000/store");
//				
//		Assert.assertEquals(res.getStatusCode(),(200));	
//		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
//		
//		String bookname=res.jsonPath().get("book[3].title").toString();
//		Assert.assertEquals(bookname, "The Lord of the Rings");
		
		
			
		//////////////////////////////////JSONObject class/////////////////////////////////////
		 // to fetch only title from json response
		
//		
		@Test(priority = 1)
		void testJsonResponseBodyData()
		{
		
		Response res = given()
				.contentType(ContentType.JSON)
				
				.when()
					.get("http://localhost:3000/store");
		
		//using json object class
		JSONObject jo =new JSONObject(res.asString());                 // converting response to json object type
		
		
		//print all title of books
		for(int i=0; i<jo.getJSONArray("book").length(); i++)        // find all json length()
		{
			
			//capture title from every object by using index
			
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString(); 
			System.out.println(bookTitle);
		}
//		
//		
//		
//		//search for title of the boo in json - validation 1
//		
//		boolean status=false;
//		
//		for(int i=0; i<jo.getJSONArray("book").length(); i++)        // find all json length()
//		{
//			
//			//capture title from every object by using index
//			
//			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString(); 
//			
//			if(bookTitle.equals("The Lord of the Rings"))
//			{
//				status=true;
//				break;
//			}
//			
//	}
//		Assert.assertEquals(status, true);
//		
//		
//		
//		//validate total price of book - validation 2
//		
//		double totalprice=0;
//		
//		for(int i=0; i<jo.getJSONArray("book").length(); i++)        // find all json length()
//		{
//			
//			//capture title from every object by using index
//			
//			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString(); 
//			
//			totalprice=totalprice+Double.parseDouble(price);
//		}
//		System.out.println("total price of books is:"+ totalprice);
//			Assert.assertEquals(totalprice, 526.0);
			

}}
