package Day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {
	
//	@Test(priority = 1)
//	void testHeaders()
//	{
//		
//		given()
//		
//		.when()
//			
//			.get("https://www.google.com/")
//		
//		.then()
//			.header("Content-Type", "text/html; charset=ISO-8859-1")
//			.and()                                                     // not neccessary to use and method..for multiple headres we can use and method
//			.header("Content-Encoding", "gzip")
//			.and()
//			.header("Server", "gws");
//			
//	}

	// capture information from headers
		
		@Test(priority = 1)
		void testHeaders()
		{
			
			Response res=  given()
			
			.when()
				
				.get("https://www.google.com/");
			
			// get single header value
				
				//String headervalue= res.getHeader("Content-Type");                 // header --single value/ headers-- multiple headers
				//System.out.println("The value of content type is :"+ headervalue);
				
			// get all headers info
			Headers myheaders =res.getHeaders();
			for(Header hd:myheaders)
			{
				System.out.println(hd.getName()+"       "+ hd.getValue());
			}
}
		}
