package SerializationDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class Deserialization {
	
	
	
	// convert json to POJO ---(Deserialization)
	
	@Test
	
	void convertJson2Pojo() throws JsonMappingException, JsonProcessingException
	{
		
		String jsondata="{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"c\", \"c++\" ]\r\n"
				+ "}";
		
		// converting json data into pojo class object
		
		ObjectMapper objMapper= new ObjectMapper();
		
		Student stupojo = objMapper.readValue(jsondata, Student.class);  // convert json to pojo
		
		System.out.println("Name:"+stupojo.getName());
		System.out.println("Location:"+stupojo.getLocation());
		System.out.println("Phone:"+stupojo.getPhone());
		System.out.println("Courses:"+Arrays.toString(stupojo.getCourses()));
		
	}

}
