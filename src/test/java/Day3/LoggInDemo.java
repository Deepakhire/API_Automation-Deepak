package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.http.HttpResponse.BodyHandler;

import org.testng.annotations.Test;

import com.github.scribejava.core.httpclient.AbstractAsyncOnlyHttpClient;

public class LoggInDemo {
	
	
	@Test
	void testLoggs()
	{
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2&id=5")
		
		.then()
			//.log().body();          // .body returns only body not all response
		
			//.log().cookies();       // .cookies only provides cookies info
			
			//.log().headers();       // .headers only provides headers info
			
			.log().all();             //.all provides all info
		
		
	}
}
