package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testQueryAndPathParametes()

	
	{
		
		given() 
			.pathParam("mypath", "users")     //path parameter   mypath is variable for "page"
			.queryParam("page", 2)            //query parameter   query parameter does not have variable
			.queryParam("id", 5)              //query parameter   query parameter used to filter the data
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
}
