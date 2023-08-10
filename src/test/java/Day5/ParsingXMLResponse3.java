package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.awt.dnd.DropTargetListener;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse3 {
	
	@Test
	void testXMLResponse()
	{
		
		
		//Approach2
		
		
		Response res =
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj= new XmlPath(res.asString());
		
		//verify total num of traveler
		List<String> travellers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
		
		//verify traveler name is present in response--way1
//		List<String> traveller_names=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
//		for(String travellername:traveller_names)
//		{
//			System.out.println(travellername);
//		}
		
		
		
		//verify traveler name is present in response--way2
		
		List<String> traveller_names=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status=false;
		for(String travellername:traveller_names)
		{
		if (travellername.equals("AS")) 
		{
			status=true;
			break;
		}
		}
		Assert.assertEquals(status, true);
}
}
