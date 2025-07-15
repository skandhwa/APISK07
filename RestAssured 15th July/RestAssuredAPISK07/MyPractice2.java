package APISK07.RestAssuredAPISK07;

import static io.restassured.RestAssured.given;

import java.net.http.HttpTimeoutException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyPractice2 {

	public static void main(String[] args) throws HttpTimeoutException {
		
		RestAssured.baseURI="https://reqres.in";
		
	 Response res=	given().log().all().queryParam("page","2").headers("x-api-key","reqres-free-v1")
		.when().get("api/users/2")
		.then().log().all().extract().response();
	 
	long Time=   res.getTime();
	res.asString();
	
	
	if(Time <5000)
	{
		System.out.println("Test case passed");
	}
	else
	{
		throw new HttpTimeoutException("Taking longer time") ;
	}
	
	
	 
		
		
		
		
		

	}

}
