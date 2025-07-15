package APISK07.RestAssuredAPISK07;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

import java.net.http.HttpTimeoutException;

import org.testng.Assert;

import PayloadData.Payload;

public class MyPractice3 {

	public static void main(String[] args) throws HttpTimeoutException {
		
		
		RestAssured.baseURI="https://reqres.in";
		
Response res=		given().log().all().headers("x-api-key","reqres-free-v1")
                    .headers("Content-Type","application/json")
		.body(Payload.addEmployeeDetails("Tom","Manager"))
		.when().post("api/users")
		.then().log().all().statusCode(201).body("name", equalTo("Tom")).
		extract().response();

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

String Response=res.asString();
System.out.println(Response);

JsonPath js=new JsonPath(Response);
String CreatedDate=js.getString("createdAt");

String []Date=CreatedDate.split("T");
System.out.println(Date[0]);

Assert.assertEquals(Date[0], java.time.LocalDate.now().toString());











		
		

	}

}
