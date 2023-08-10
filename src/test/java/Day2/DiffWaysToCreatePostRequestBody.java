package Day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONTokener;

//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import java.io.File;
//import java.io.Reader;
//
//import org.json.JSONObject;
//import org.json.JSONTokener;
//import org.json.JSONTokener;
//import org.testng.annotations.Test;
//
//import io.restassured.internal.support.FileReader;


//Different ways to create Post Request
	//1. Post request using HAshMap
	//2. Post request using org.json
	//3. Post request using POJO class
	//4. Post request using file data

public class DiffWaysToCreatePostRequestBody {
	
	///////////////////////////////////////1. Post request using HAshMap//////////////////////////////////////
	
//	@Test(priority = 1)
//	void testPostUsingHashmap()
//	{
		
//		HashMap data = new HashMap();
//		
//		data.put("name", "Scott");
//		data.put("location", "France");
//		data.put("phone", "123456");
//		
//		String courseArr [] = {"c","c++"};
//		data.put("courses", courseArr);
//		
//		given()
//			.contentType("application/json")
//			.body(data)
//		
//		.when()
//			.post("http://localhost:3000/students")
//		
//		.then()
//			.statusCode(201)
//			.body("name",equalTo("Scott"))
//			.body("location",equalTo("France"))
//			.body("phone",equalTo("123456"))
//			.body("courses[0]",equalTo("c"))
//			.body("courses[1]",equalTo("c++"))
//			.headers("Content-Type","application/json; charset=utf-8")
//			.log().all();
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
//		HashMap hm=new HashMap();
//
//	    hm.put("name", "Ashu");
//	    hm.put("location", "France");
//	    hm.put("phone", "87876999");
//
//	    String courseArr[]= {"C","C++"};
//	    hm.put("courses", courseArr);
//
//	    given()
//	        .contentType("application/json")
//	        .body(hm)
//
//	    .when()
//	        .post("http://localhost:3000/students")
//
//	    .then()
//	        .statusCode(201)
//	        .body("name",equalTo("Ashu"))
//	        .body("location",equalTo("France"))
//	        .body("phone",equalTo("87876999"))
//	        .body("courses[0]",equalTo("C"))
//	        .body("courses[1]",equalTo("C++"))
//	        .header("Content-Type", "application/json; charset=utf-8")
//	        .log().all();
	
	
	
	/////////////////////////////////////////2. Post request using json library/////////////////////////////////////
//		
//		@Test(priority = 1)
//		void testPostUsingJsonLibrary()
//		{
//		
//		
//JSONObject data = new JSONObject();
//		
//		data.put("name", "Scott");
//		data.put("location", "France");
//		data.put("phone", "123456");
//		
//		String courseArr [] = {"c","c++"};
//		data.put("courses", courseArr);
//		
//		given()
//			.contentType("application/json")
//			.body(data.toString())
//		
//		.when()
//			.post("http://localhost:3000/students")
//		
//		.then()
//			.statusCode(201)
//			.body("name",equalTo("Scott"))
//			.body("location",equalTo("France"))
//			.body("phone",equalTo("123456"))
//			.body("courses[0]",equalTo("c"))
//			.body("courses[1]",equalTo("c++"))
//			.headers("Content-Type","application/json; charset=utf-8")
//			.log().all();
	
	
	
	///////////////////////////////////// 3.Post request body using POJO class////////////////////////////////////
	
	
	
	
//	@Test(priority = 1)
//	void testPostUsingPOJOClass()
//	{
//	
//		POJO_PostRequest data = new POJO_PostRequest();
//		
//		data.setName("Scott");
//		data.setLocation("France");
//		data.setPhone("123456");
//		String coursesArr[] = {"c","c++"};
//		data.setCourses(coursesArr);
//		
//		
//
//	given()
//		.contentType("application/json")
//		.body(data)
//	
//	.when()
//		.post("http://localhost:3000/students")
//	
//	.then()
//		.statusCode(201)
//		.body("name",equalTo("Scott"))
//		.body("location",equalTo("France"))
//		.body("phone",equalTo("123456"))
//		.body("courses[0]",equalTo("c"))
//		.body("courses[1]",equalTo("c++"))
//		.headers("Content-Type","application/json; charset=utf-8")
//		.log().all();
	

	
	////////////////////////////////////////4.Post request body using external json file/////////////////////
	
	@Test(priority = 1)
	void testPostUsingExternalJsonFile() throws FileNotFoundException
	{
	
		//to get the data from external file first we have to open the file

        File f=new File(".\\body.json"); 

        //read data from file
        FileReader fr=new FileReader(f); //f is passing here to open the file

        //we have to split that file into different token
        JSONTokener jt =new JSONTokener(fr);

        //we have to extract data in json object format
        JSONObject data=new JSONObject(jt); //this will throw exception we have to add it
		

	given()
		.contentType("application/json")
		.body(data.toString())
	
	.when()
		.post("http://localhost:3000/students")
	
	.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("123456"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))
		.headers("Content-Type","application/json; charset=utf-8")
		.log().all();

	    }

		
	//deleting student record
	@Test(priority = 2)
	
	void testDelete()
	{
		
		given()
		
		.when()
			.delete("http://localhost:3000/students/7")
		
		.then()
			.statusCode(200);
	}}
		

	

