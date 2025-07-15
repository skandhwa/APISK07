package APISK07.RestAssuredAPISK07;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class HandlingStaticPayloadEx {

	public static void main(String[] args) throws IOException {
		
		RestAssured.baseURI="https://reqres.in";
	String Response=	given().log().all().headers("Content-Type","application/json")
		.headers("x-api-key","reqres-free-v1")
		.body(new String(Files.
				readAllBytes(Paths.get("E:\\TestData27thJune.txt")))).
		
		
		when().post("api/users")
		.then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
	
	System.out.println(Response);
		
		

	}

}
