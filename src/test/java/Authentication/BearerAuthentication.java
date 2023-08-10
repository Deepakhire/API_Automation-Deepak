package Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BearerAuthentication {
	
	@Test
	
	void testBearerAuthentication()
	{
		
		String bearerToken="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";
		
		given()
			.headers("Authorisation","Bearer"+bearerToken )
		.when()
			.get("https://github.com/")
		
		.then()
			.statusCode(200)
			.log().all();
		
		
	}

}
