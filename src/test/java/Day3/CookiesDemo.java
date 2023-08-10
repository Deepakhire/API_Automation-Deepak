package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	
//	@Test(priority = 1)
//	void testCookies()
//	{
//		
//		given()
//		
//		.when()
//			.cookie("AEC","Ad49MVEitvOsdb3AmsljFK9ND5e7v0e7tYISTCNm6wQllOWgGWHU7YqiGNw")
//			.get("https://www.google.com/")
//		
//		.then()
//			.log().all();
//		
//		
//	}
	
	
	
	@Test(priority = 2)
	void getCookiesInfo()
	{
		// when we want to get entire response then no need to put then() method
		
   Response res = given()
		
		.when()
			
			.get("https://www.google.com/");
   
// get single cookie info
   
//   String cookie_value= res.getCookie("ACE");                       // here we extract the value of particular cocokies
//   System.out.println("Value of cookie is====>"+ cookie_value);
   
   
   // get all cookie info
   Map<String, String> cookies_values=res.getCookies();
   
  //System.out.println(cookies_values.keySet());                         // this gives us only key info
   
   
   
   
 for(String k:cookies_values.keySet())                                   // put every key in variable
 {
	 String cookie_value= res.getCookie(k); 
	 System.out.println(k+"---------"+ cookies_values);
 }
 
 
}
	
}












