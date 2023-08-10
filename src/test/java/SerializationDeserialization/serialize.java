package SerializationDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// POJO -----serialization-->JSON Object

public class serialize {
	
	
	// convert POJO to JSON ---(Serialization)
	
	@Test
	void convertpojo2json() throws JsonProcessingException
	{
		// created java object into POJO class
		Student stupojo= new Student();       //pojo
		 
		stupojo.setName("Scott");
		stupojo.setLocation("France");
		stupojo.setPhone("123456");
		
		String courseArr [] = {"c","c++"};
		stupojo.setCourses(courseArr);
		
		//convert java object ---> json object (serealization)
		
		ObjectMapper objMapper =new ObjectMapper();
		
		  String jsondata= objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		System.out.println(jsondata);
	}

}
