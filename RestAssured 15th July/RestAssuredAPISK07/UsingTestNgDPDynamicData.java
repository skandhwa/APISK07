package APISK07.RestAssuredAPISK07;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayloadData.Payload;
import io.restassured.RestAssured;

public class UsingTestNgDPDynamicData {

	@DataProvider(name="booksData")
	public Object [][] getData()
	{
		return new Object [][]
				
				{
			{"nbfg","7865","Harry"},{"kgbh","8764","Tom"},{"tdes","6543","John"}
			 
				};
	}
	
	@Test(dataProvider="booksData")
	public void addBook(String isbn, String aisle,String author)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		String Response=		given().log().all().headers("Content-Type","application/json")
				.body(Payload.bookDetails(isbn, aisle, author))
				.when().post("Library/Addbook.php")	.then().log().all().
				assertThat().statusCode(200).extract().response().asString();
				
			System.out.println("The Response is   "+Response);
	}
	
	
	
	

}
