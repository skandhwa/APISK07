package APISK07.RestAssuredAPISK07;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UsingMaptoPassData {

	public static void main(String[] args) {
		
		Map<String,Object> mp=new LinkedHashMap<String,Object>();
		String u_isbn="" + (char)('a' + Math.random() * 26) + (char)('a' + Math.random() * 26) + (char)('a' + Math.random() * 26) + (char)('a' + Math.random() * 26);
		int u_aisle=1000 + (int)(Math.random() * 9000);
		
		mp.put("name", "Java Selenium");
		mp.put("isbn", u_isbn);
		mp.put("aisle", u_aisle);
		mp.put("author", "John foe");
		
		
		RestAssured.baseURI="http://216.10.245.166";
		
String Response=		given().log().all().headers("Content-Type","application/json")
		.body(mp)
		.when().post("Library/Addbook.php")	.then().log().all().
		assertThat().statusCode(200).extract().response().asString();
		
	System.out.println("The Response is   "+Response);
	
	
	String ExpectedId=u_isbn+u_aisle;
	
	
	JsonPath js=new JsonPath(Response);
	String Actual_ID=js.getString("ID");
	
	Assert.assertEquals(Actual_ID, ExpectedId);
	System.out.println("Test Case passed");
	
	
	
	
	
	
	
		
		
		
		
		

	}

}
