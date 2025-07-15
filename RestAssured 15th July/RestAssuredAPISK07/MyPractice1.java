package APISK07.RestAssuredAPISK07;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MyPractice1 {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in";
		
String Response=		given().log().all().headers("x-api-key","reqres-free-v1")
		.when().get("api/users")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();


System.out.println(Response);

JsonPath js=new JsonPath(Response);

int totalPages=js.getInt("total_pages");
Assert.assertEquals(totalPages, 2);
System.out.println("My test case passed");




		
		
		
		

	}

}
